package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.models.VideoStreamItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig.VideoPlayerConfig;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;
import com.github.kotvertolet.youtubejextractor.utils.DecryptionUtils;
import com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils;
import com.github.kotvertolet.youtubejextractor.utils.YoutubePlayerUtils;
import com.google.code.regexp.Matcher;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogE;
import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogI;
import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.getMatcher;
import static com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils.extractStsFromVideoPageHtml;
import static com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils.isVideoAgeRestricted;
import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.splitUrlParams;

public class YoutubeJExtractor {

    private final String TAG;
    private final YoutubeSiteNetwork youtubeSiteNetwork;
    private final Gson gson;
    private String videoPageHtml;

    public YoutubeJExtractor() {
        TAG = getClass().getSimpleName();
        youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
        gson = new Gson();
    }

    public YoutubeJExtractor(OkHttpClient client) {
        TAG = getClass().getSimpleName();
        youtubeSiteNetwork = YoutubeSiteNetwork.getInstance(client);
        gson = new Gson();
    }

    public YoutubeVideoData extract(String videoId) throws ExtractionException, YoutubeRequestException {
        try {
            YoutubeVideoData youtubeVideoData = extractYoutubeVideoData(videoId);
            if (areStreamsAreEncrypted(youtubeVideoData)) {
                return decryptYoutubeStreams(youtubeVideoData);
            }
            return youtubeVideoData;
        } catch (SignatureDecryptionException e) {
            throw new ExtractionException(e);
        }
    }

    private YoutubeVideoData extractYoutubeVideoData(String videoId) throws ExtractionException, YoutubeRequestException {
        URL url;
        List<Map<String, String>> adaptiveFormatsData = new ArrayList<>();
        String rawYoutubeVideoData;
        try {
            videoPageHtml = youtubeSiteNetwork.getYoutubeVideoPage(videoId).body().string();
            Matcher matcher = getMatcher("<link rel=\"canonical\"\\shref=(\"\\S+\")", videoPageHtml);
            if (!matcher.find()) {
                throw new ExtractionException(String.format("Invalid video page received, " +
                        "maybe video id '%s' is not valid", videoId));
            }
            //Protocol and domain are necessary to split url params correctly
            String urlProtocolAndDomain = "http://youtube.con/v?";
            if (isVideoAgeRestricted(videoPageHtml)) {
                String videoInfo = getVideoInfoForAgeRestrictedVideo(videoId);
                url = new URL(urlProtocolAndDomain + videoInfo);
                Map<String, String> infoMap = splitUrlParams(url);
                adaptiveFormatsData = extractAdaptiveFormatsData(infoMap);
                rawYoutubeVideoData = infoMap.get("player_response");
            } else {
                VideoPlayerConfig youtubePlayerConfig = extractYoutubePlayerConfig(videoId);
                String[] rawAdaptiveFormatsArr = youtubePlayerConfig.getArgs().getAdaptiveFmts().split(",");
                for (String rawAdaptiveFormat : rawAdaptiveFormatsArr) {
                    url = new URL(urlProtocolAndDomain + rawAdaptiveFormat);
                    adaptiveFormatsData.add(splitUrlParams(url));
                }
                rawYoutubeVideoData = youtubePlayerConfig.getArgs().getPlayerResponse();
            }
        } catch (IOException e) {
            throw new ExtractionException(e);
        }
        YoutubeVideoData youtubeVideoData = gson.fromJson(rawYoutubeVideoData, YoutubeVideoData.class);
        youtubeVideoData = extractAudioAndVideoStreams(youtubeVideoData, adaptiveFormatsData);
        return youtubeVideoData;
    }

    private List<Map<String, String>> extractAdaptiveFormatsData(Map<String, String> infoMap) throws ExtractionException {
        List<Map<String, String>> adaptiveFormatsDataList = new ArrayList<>();
        String adaptiveFormats = infoMap.get("adaptive_fmts");
        String[] streamDataQueryStringList;
        if (adaptiveFormats != null && !adaptiveFormats.isEmpty()) {
            streamDataQueryStringList = adaptiveFormats.split(",");
            for (String streamDataQueryString : streamDataQueryStringList) {
                Map<String, String> urlParamsMap = splitUrlParams(streamDataQueryString);
                adaptiveFormatsDataList.add(urlParamsMap);
            }
        }
        return adaptiveFormatsDataList;
    }

    private VideoPlayerConfig extractYoutubePlayerConfig(String videoId) throws ExtractionException {
        Matcher matcher = getMatcher("ytplayer\\.config\\s*=\\s*(\\{.+?\\})\\;ytplayer", videoPageHtml);
        String rawPlayerConfig;
        if (matcher.find()) {
            rawPlayerConfig = matcher.group(1);
            return gson.fromJson(rawPlayerConfig, VideoPlayerConfig.class);
        } else {
            matcher = getMatcher("<h1\\sid=\"unavailable-message\"\\sclass=\"message\">\\n\\s+(.+?)\\n\\s+<\\/h1>", videoPageHtml);
            if (matcher.find()) {
                throw new ExtractionException(String.format("Cannot extract youtube player config, " +
                        "videoId was: %s, reason: %s", videoId, matcher.group(1)));
            }
            else throw new ExtractionException("Cannot extract youtube player config," +
                    " videoId was: " + videoId);
        }
    }

    private YoutubeVideoData extractAudioAndVideoStreams(YoutubeVideoData youtubeVideoData,
                                                      List<Map<String, String>> adaptiveFormatsList) {
        StreamingData streamingData = youtubeVideoData.getStreamingData();
        List<VideoStreamItem> videoStreamItems = new ArrayList<>();
        List<AudioStreamItem> audioStreamItems = new ArrayList<>();
        for (int i = 0; i < adaptiveFormatsList.size(); i++) {
            Map<String, String> adaptiveFormatDataMap = adaptiveFormatsList.get(i);
            String streamType = adaptiveFormatDataMap.get("type");
            if (streamType == null || streamType.isEmpty()) {
                LogE(TAG, "Null or empty stream type found");
            } else {
                if (streamType.contains("video")) {
                    videoStreamItems.add(new VideoStreamItem(adaptiveFormatDataMap));
                } else if (streamType.contains("audio")) {
                    audioStreamItems.add(new AudioStreamItem(adaptiveFormatDataMap));
                } else {
                    LogE(TAG, "Unknown stream type found: " + streamType);
                }
            }
        }
        streamingData.setAudioStreamItems(audioStreamItems);
        streamingData.setVideoStreamItems(videoStreamItems);
        return youtubeVideoData;
    }

    private String getVideoInfoForAgeRestrictedVideo(String videoId) throws ExtractionException {
        try {
            LogI(TAG, "Age restricted video detected, videoId: " + videoId);
            this.videoPageHtml = youtubeSiteNetwork.getYoutubeEmbeddedVideoPage(videoId).body().string();
            String eUrl;
            try {
                String sts = extractStsFromVideoPageHtml(videoPageHtml);
                eUrl = String.format("https://youtube.googleapis.com/v/%s&sts=%s", videoId, sts);
                LogI(TAG, "Sts param wasn't found in video page html code, trying to get video info without it");
            }
            catch (ExtractionException e) {
                eUrl = String.format("https://youtube.googleapis.com/v/%s", videoId);
            }
            Response<ResponseBody> videoInfoResponse = youtubeSiteNetwork.getYoutubeVideoInfo(videoId, eUrl);
            return videoInfoResponse.body().string();
        } catch (IOException | NullPointerException | YoutubeRequestException e) {
            throw new ExtractionException(e);
        }
    }

    private boolean areStreamsAreEncrypted(YoutubeVideoData youtubeVideoData) {
        // Even if a single stream is encrypted it means they all are
        return youtubeVideoData.getStreamingData().getVideoStreamItems().get(0).isStreamEncrypted();
    }

    private YoutubeVideoData decryptYoutubeStreams(YoutubeVideoData youtubeVideoData) throws ExtractionException, SignatureDecryptionException, YoutubeRequestException {
        List<VideoStreamItem> videoStreamItems = youtubeVideoData.getStreamingData().getVideoStreamItems();
        List<AudioStreamItem> audioStreamItems = youtubeVideoData.getStreamingData().getAudioStreamItems();

        String playerUrl = YoutubePlayerUtils.getJsPlayerUrl(videoPageHtml);
        ExtractionUtils extractionUtils = new ExtractionUtils();
        String youtubeVideoPlayerCode = extractionUtils.extractYoutubeVideoPlayerCode(playerUrl);
        String decryptFunctionName = extractionUtils.extractDecryptFunctionName(youtubeVideoPlayerCode);
        DecryptionUtils decryptionUtils = new DecryptionUtils(youtubeVideoPlayerCode, decryptFunctionName);
        for (int i = 0; i < videoStreamItems.size(); i++) {
            String encryptedSignature = videoStreamItems.get(i).getSignature();
            String decryptedSignature = decryptionUtils.decryptSignature(encryptedSignature);
            videoStreamItems.get(i).setSignature(decryptedSignature);
        }
        for (int i = 0; i < audioStreamItems.size(); i++) {
            String encryptedSignature = audioStreamItems.get(i).getSignature();
            String decryptedSignature = decryptionUtils.decryptSignature(encryptedSignature);
            audioStreamItems.get(i).setSignature(decryptedSignature);
        }
        return youtubeVideoData;
    }
}
