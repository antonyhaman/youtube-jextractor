package com.github.kotvertolet.youtubejextractor;

import android.util.Log;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerConfig.VideoPlayerConfig;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.AdaptiveStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.PlayerResponse;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.RawStreamingData;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;
import com.github.kotvertolet.youtubejextractor.utils.DecryptionUtils;
import com.github.kotvertolet.youtubejextractor.utils.ExtractionUtils;
import com.github.kotvertolet.youtubejextractor.utils.YoutubePlayerUtils;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogI;
import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.splitUrlParams;
import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.urlDecode;
import static com.github.kotvertolet.youtubejextractor.utils.StringUtils.urlParamsToJson;

public class YoutubeJExtractor {

    private final static String ERROR_MESSAGE = "Extraction failed. Please, report here: https://github.com/kotvertolet/youtube-jextractor/issues. Error details: ";
    private final String TAG = getClass().getSimpleName();
    private final YoutubeSiteNetwork youtubeSiteNetwork;
    private final YoutubePlayerUtils youtubePlayerUtils;
    private final ExtractionUtils extractionUtils;
    private final Gson gson;
    private String videoPageHtml;

    /**
     * No-args constructor
     */
    public YoutubeJExtractor() {
        gson = initGson();
        youtubeSiteNetwork = new YoutubeSiteNetwork(gson);
        youtubePlayerUtils = new YoutubePlayerUtils(youtubeSiteNetwork);
        extractionUtils = new ExtractionUtils(youtubePlayerUtils);
    }

    /**
     * Constructs YoutubeJExtractor with custom OkHttpClient instance which allows for ex.
     * to use custom proxy to deal with region restricted video
     *
     * @param client Custom OkHttpClient instance
     */
    public YoutubeJExtractor(OkHttpClient client) {
        gson = initGson();
        youtubeSiteNetwork = new YoutubeSiteNetwork(gson, client);
        youtubePlayerUtils = new YoutubePlayerUtils(youtubeSiteNetwork);
        extractionUtils = new ExtractionUtils(youtubePlayerUtils);
    }

    public YoutubeVideoData extract(String videoId) throws ExtractionException, YoutubeRequestException {
        try {
            LogI(TAG, "Extracting video data from youtube page");
            PlayerResponse playerResponse = extractYoutubeVideoData(videoId);
            if (areStreamsAreEncrypted(playerResponse)) {
                LogI(TAG, "Streams are encrypted, decrypting");
                decryptYoutubeStreams(playerResponse);
            }
            else LogI(TAG, "Streams are not encrypted");
            return new YoutubeVideoData(playerResponse.getVideoDetails(), playerResponse.getRawStreamingData());
        } catch (SignatureDecryptionException e) {
            throw new ExtractionException(e);
        }
    }

    private PlayerResponse extractYoutubeVideoData(String videoId) throws ExtractionException, YoutubeRequestException {
        PlayerResponse playerResponse;
        try {
            URL url;
            videoPageHtml = youtubeSiteNetwork.getYoutubeVideoPage(videoId).body().string();
            //Protocol and domain are necessary to split url params correctly
            String urlProtocolAndDomain = "http://youtube.con/v?";
            if (extractionUtils.isVideoAgeRestricted(videoPageHtml)) {
                LogI(TAG, "Age restricted video detected, getting video data from google apis");
                String videoInfo = getVideoInfoForAgeRestrictedVideo(videoId);
                url = new URL(urlProtocolAndDomain + videoInfo);
                Map<String, String> videoInfoMap = splitUrlParams(url);
                String rawPlayerResponse = videoInfoMap.get("player_response");
                if (rawPlayerResponse == null || rawPlayerResponse.isEmpty()) {
                    throw new ExtractionException(ERROR_MESSAGE + "Player response extracted from video info was null or empty");
                }
                playerResponse = gson.fromJson(gson.toJson(videoInfoMap.get("player_response")), PlayerResponse.class);

            } else {
                LogI(TAG, "Video is not age restricted, extracting youtube video player config");
                playerResponse = extractYoutubePlayerConfig(videoId).getArgs().getPlayerResponse();
            }
        } catch (IOException e) {
            throw new ExtractionException(e);
        }
        return playerResponse;
    }

    private VideoPlayerConfig extractYoutubePlayerConfig(String videoId) throws ExtractionException {
        Pattern playerConfigPattern = Pattern.compile("ytplayer\\.config\\s*=\\s*(\\{.+?\\})\\;ytplayer");
        Matcher matcher = playerConfigPattern.matcher(videoPageHtml);
        String rawPlayerConfig;
        if (matcher.find()) {
            rawPlayerConfig = matcher.group(1);
            return gson.fromJson(rawPlayerConfig, VideoPlayerConfig.class);
        } else {
            Pattern videoIsUnavailableMessagePattern = Pattern.compile("<h1\\sid=\"unavailable-message\"\\sclass=\"message\">\\n\\s+(.+?)\\n\\s+<\\/h1>");
            matcher = videoIsUnavailableMessagePattern.matcher(videoPageHtml);
            if (matcher.find()) {
                throw new ExtractionException(ERROR_MESSAGE +
                        String.format("Cannot extract youtube player config, videoId was: %s, reason: %s",
                                videoId, matcher.group(1)));
            } else throw new ExtractionException(ERROR_MESSAGE  +
                    "Cannot extract youtube player config, videoId was: " + videoId);
        }
    }

    private String getVideoInfoForAgeRestrictedVideo(String videoId) throws ExtractionException {
        try {
            this.videoPageHtml = youtubeSiteNetwork.getYoutubeEmbeddedVideoPage(videoId).body().string();
            String sts = extractionUtils.extractStsFromVideoPageHtml(videoPageHtml);
            String eUrl = String.format("https://youtube.googleapis.com/v/%s&sts=%s", videoId, sts);
            Response<ResponseBody> videoInfoResponse = youtubeSiteNetwork.getYoutubeVideoInfo(videoId, eUrl);
            if (videoInfoResponse.body() != null) {
                String videoInfo = videoInfoResponse.body().string();
                if (videoInfo.isEmpty())
                    throw new ExtractionException(ERROR_MESSAGE + "Video info was empty");
                else return videoInfo;
            } else {
                throw new ExtractionException(ERROR_MESSAGE + "Video info response body was null or empty");
            }
        } catch (IOException | NullPointerException | YoutubeRequestException e) {
            throw new ExtractionException(e);
        }
    }

    private boolean areStreamsAreEncrypted(PlayerResponse playerResponse) throws ExtractionException {
        // Even if a single stream is encrypted it means they all are
        RawStreamingData rawStreamingData = playerResponse.getRawStreamingData();
        if (rawStreamingData != null) {
            List<AdaptiveStream> formatItems = rawStreamingData.getAdaptiveStreams();
            if (playerResponse.getVideoDetails().isLiveContent()) {
                Log.i(TAG, "Requested content is live stream");
                if (formatItems == null || formatItems.size() == 0) {
                    Log.i(TAG, "Requested content is a live stream and doesn't contain adaptive streams, " +
                            "use DASH or HLS manifests. If the content is not a live stream or it was but has ended, " +
                            "just wait some time, youtube usually needs a couple of hours to prepare adaptive streams");
                    return false;
                }
            }
            if (formatItems != null && formatItems.size() > 0) {
                return formatItems.get(0).getCipher() != null;
            }
            else throw new ExtractionException(ERROR_MESSAGE + "AdaptiveFormatItem list was null or empty");
        } else throw new ExtractionException(ERROR_MESSAGE + "RawStreamingData object was null");
    }

    private void decryptYoutubeStreams(PlayerResponse youtubeVideoData) throws ExtractionException, SignatureDecryptionException, YoutubeRequestException {
        List<AdaptiveStream> adaptiveStreams = youtubeVideoData.getRawStreamingData().getAdaptiveStreams();
        List<MuxedStream> muxedStreams = youtubeVideoData.getRawStreamingData().getMuxedStreams();

        String playerUrl = youtubePlayerUtils.getJsPlayerUrl(videoPageHtml);
        String youtubeVideoPlayerCode = extractionUtils.extractYoutubeVideoPlayerCode(playerUrl);
        String decryptFunctionName = extractionUtils.extractDecryptFunctionName(youtubeVideoPlayerCode);
        DecryptionUtils decryptionUtils = new DecryptionUtils(youtubeVideoPlayerCode, decryptFunctionName);
        for (int i = 0; i < adaptiveStreams.size(); i++) {
            String encryptedSignature = adaptiveStreams.get(i).getCipher().getS();
            String decryptedSignature = decryptionUtils.decryptSignature(encryptedSignature);
            adaptiveStreams.get(i).getCipher().setS(decryptedSignature);
        }
        for (int i = 0; i < muxedStreams.size(); i++) {
            String encryptedSignature = muxedStreams.get(i).getCipher().getS();
            String decryptedSignature = decryptionUtils.decryptSignature(encryptedSignature);
            muxedStreams.get(i).getCipher().setS(decryptedSignature);
        }
    }

    private Gson initGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Cipher> cipherDeserializer = (json, typeOfT, context) -> {
            Cipher cipher = gson.fromJson(urlParamsToJson(json.getAsString()), Cipher.class);
            cipher.setUrl(urlDecode(cipher.getUrl()));
            return cipher;
        };

        JsonDeserializer<PlayerResponse> playerResponseJsonDeserializer = (json, typeOfT, context) -> {
            Gson tempGson = new GsonBuilder().registerTypeAdapter(Cipher.class, cipherDeserializer).create();
            String jsonRaw = json.getAsString();
            return tempGson.fromJson(jsonRaw, PlayerResponse.class);
        };
        gsonBuilder.registerTypeAdapter(PlayerResponse.class, playerResponseJsonDeserializer);
        return gsonBuilder.create();
    }
}