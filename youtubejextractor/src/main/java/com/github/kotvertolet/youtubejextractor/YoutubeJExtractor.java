package com.github.kotvertolet.youtubejextractor;

import android.util.Log;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;
import com.github.kotvertolet.youtubejextractor.pojo.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.pojo.VideoStreamItem;
import com.github.kotvertolet.youtubejextractor.pojo.youtubeInnerData.StreamingData;
import com.github.kotvertolet.youtubejextractor.pojo.youtubeInnerData.YoutubeVideoData;
import com.github.kotvertolet.youtubejextractor.utils.DecryptionUtils;
import com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils;
import com.github.kotvertolet.youtubejextractor.utils.YoutubePlayerUtils;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.splitUrlParams;

public class YoutubeJExtractor {

    private YoutubeSiteNetwork youtubeSiteNetwork;
    private String embeddedVideoPageHtml;

    public YoutubeJExtractor() {
        youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    }

    public YoutubeVideoData extract(String videoId) throws SignatureDecryptionException, ExtractionException, YoutubeRequestException {
        YoutubeVideoData youtubeVideoData = getYoutubeVideoData(videoId);
        List<VideoStreamItem> videoStreamItems = youtubeVideoData.getStreamingData().getVideoStreamItems();
        List<AudioStreamItem> audioStreamItems = youtubeVideoData.getStreamingData().getAudioStreamItems();
        // If a single stream is encrypted means they all are
        VideoStreamItem exampleStream = videoStreamItems.get(0);
        if (exampleStream.isStreamEncrypted()) {
            String playerUrl = YoutubePlayerUtils.getJsPlayerUrl(embeddedVideoPageHtml);
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
        }
        return youtubeVideoData;
    }

    private YoutubeVideoData getYoutubeVideoData(String videoId) throws ExtractionException, YoutubeRequestException {
        String allInfo = getVideoInfo(videoId);
        // Necessary to split url params correctly
        URL url;
        try {
            url = new URL("http://youtube.con/v?" + allInfo);
        } catch (MalformedURLException e) {
            throw new ExtractionException(e);
        }
        Map<String, String> infoMap = splitUrlParams(url);
        List<Map<String, String>> adaptiveFormatsData = extractAdaptiveFormatsData(infoMap);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(infoMap.get("player_response"), JsonObject.class);
        YoutubeVideoData youtubeVideoData = gson.fromJson(jsonObject, YoutubeVideoData.class);

        extractAudioAndVideoStreams(youtubeVideoData.getStreamingData(), adaptiveFormatsData);
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

    private StreamingData extractAudioAndVideoStreams(StreamingData streamingData,
                                                      List<Map<String, String>> adaptiveFormatsList) {
        List<VideoStreamItem> videoStreamItems = new ArrayList<>();
        List<AudioStreamItem> audioStreamItems = new ArrayList<>();
        for (int i = 0; i < adaptiveFormatsList.size(); i++) {
            Map<String, String> adaptiveFormatDataMap = adaptiveFormatsList.get(i);
            String streamType = adaptiveFormatDataMap.get("type");
            if (streamType == null || streamType.isEmpty()) {
                Log.e(getClass().getSimpleName(), "Null or empty stream type found");
            } else {
                if (streamType.contains("video")) {
                    videoStreamItems.add(new VideoStreamItem(adaptiveFormatDataMap));
                } else if (streamType.contains("audio")) {
                    audioStreamItems.add(new AudioStreamItem(adaptiveFormatDataMap));
                } else {
                    Log.e(getClass().getSimpleName(), "Unknown stream type found: " + streamType);
                }
            }
        }
        streamingData.setAudioStreamItems(audioStreamItems);
        streamingData.setVideoStreamItems(videoStreamItems);
        return streamingData;
    }

    private String getVideoInfo(String videoId) throws ExtractionException, YoutubeRequestException {
        try {
            embeddedVideoPageHtml = youtubeSiteNetwork.getYoutubeEmbeddedWebpage(videoId).body().string();
        } catch (IOException | NullPointerException e) {
            throw new ExtractionException(e);
        }
        String sts = extractStsFromEmbeddedVideoPage(embeddedVideoPageHtml);
        String eUrl = String.format("https://youtube.googleapis.com/v/%s&sts=%s", videoId, sts);
        Response<ResponseBody> videoInfoResponse = youtubeSiteNetwork.getYoutubeVideoInfo(videoId, eUrl);
        try {
            return videoInfoResponse.body().string();
        } catch (IOException | NullPointerException e) {
            throw new ExtractionException(e);
        }
    }

    private String extractStsFromEmbeddedVideoPage(String embeddedVideoPageHtml) throws ExtractionException {
        Pattern pattern = Pattern.compile("sts\"\\s*:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(embeddedVideoPageHtml);
        if (matcher.find()) {
            return matcher.group(1);
        } else
            throw new ExtractionException("Sts param wasn't found in the embedded player webpage code");
    }
}
