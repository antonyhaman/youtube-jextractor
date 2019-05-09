package com.github.kotvertolet;

import com.github.kotvertolet.network.YoutubeSiteNetwork;
import com.github.kotvertolet.pojo.StreamItem;
import com.github.kotvertolet.pojo.youtubeInnerData.YoutubeVideoData;
import com.github.kotvertolet.utils.DecryptionUtils;
import com.github.kotvertolet.utils.ExtractionUtils;
import com.github.kotvertolet.utils.YoutubePlayerUtils;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.github.kotvertolet.utils.StringUtils.splitUrlParams;

public class YoutubeJExtractor {

    private YoutubeSiteNetwork youtubeSiteNetwork;
    private String embeddedVideoPageHtml;

    // Temp workaround.
    private int retryLimit = 0;

    public YoutubeJExtractor() {
        youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    }

    public YoutubeVideoData extract(String videoId) throws IOException {
        YoutubeVideoData youtubeVideoData = getYoutubeVideoData(videoId);
        List<StreamItem> streamItemList = youtubeVideoData.getStreamingData().getStreamItems();

        StreamItem exampleStream = streamItemList.get(0);
        if (exampleStream.isStreamEncrypted()) {
            /*
                Temp workaround. Check if signature has proper format or else try again,
                usually takes 1-2 attempts to get a proper signature
            */
            if (!exampleStream.getSignature().contains(".")) {
                if (retryLimit < 4) {
                    retryLimit++;
                    return extract(videoId);
                } else
                    throw new IllegalStateException("Extraction reached it's retry limit but still fails");
            }

            String playerUrl = YoutubePlayerUtils.getJsPlayerUrl(embeddedVideoPageHtml);
            ExtractionUtils extractionUtils = new ExtractionUtils();
            String youtubeVideoPlayerCode = extractionUtils.extractYoutubeVideoPlayerCode(playerUrl);
            String decryptFunctionName = extractionUtils.extractDecryptFunctionName(youtubeVideoPlayerCode);
            DecryptionUtils decryptionUtils = new DecryptionUtils(youtubeVideoPlayerCode, decryptFunctionName);

            for (int i = 0; i < streamItemList.size(); i++) {
                String encryptedSignature = streamItemList.get(i).getSignature();
                String decryptedSignature = decryptionUtils.decryptSignature(encryptedSignature);
                streamItemList.get(i).setSignature(decryptedSignature);
            }
        }
        return youtubeVideoData;
    }

    private YoutubeVideoData getYoutubeVideoData(String videoId) throws IOException {
        String allInfo = getVideoInfo(videoId);
        // Necessary to split url params correctly
        URL url = new URL("http://youtube.con/v?" + allInfo);
        Map<String, String> infoMap = splitUrlParams(url);

        List<StreamItem> streamItemList = extractAdaptiveFormatsData(infoMap);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(infoMap.get("player_response"), JsonObject.class);
        YoutubeVideoData youtubeVideoData = gson.fromJson(jsonObject, YoutubeVideoData.class);
        youtubeVideoData.getStreamingData().setStreamItems(streamItemList);
        return youtubeVideoData;
    }

    private List<StreamItem> extractAdaptiveFormatsData(Map<String, String> infoMap) throws UnsupportedEncodingException {
        List<Map<String, String>> adaptiveFormatsDataList = new ArrayList<>();
        String[] streamDataQueryStringList = infoMap.get("adaptive_fmts").split(",");
        for (String streamDataQueryString : streamDataQueryStringList) {
            Map<String, String> urlParamsMap = splitUrlParams(streamDataQueryString);
            adaptiveFormatsDataList.add(urlParamsMap);
        }
        List<StreamItem> streamItemList = new ArrayList<>();
        for (Map<String, String> adaptiveFormatDataMap : adaptiveFormatsDataList) {
            streamItemList.add(new StreamItem(adaptiveFormatDataMap));
        }
        return streamItemList;
    }

    private String getVideoInfo(String videoId) throws IOException {
        embeddedVideoPageHtml = youtubeSiteNetwork.getYoutubeEmbeddedWebpage(videoId).body().string();
        String sts = extractStsFromEmbeddedVideoPage(embeddedVideoPageHtml);
        String eUrl = String.format("https://youtube.googleapis.com/v/%s&sts=%s", videoId, sts);
        Response<ResponseBody> videoInfoResponse = youtubeSiteNetwork.getYoutubeVideoInfo(videoId, eUrl);
        if (!videoInfoResponse.isSuccessful()) {
            throw new IllegalStateException("Unable to receive youtube embedded video web page, reason: " + videoInfoResponse.errorBody());
        }
        return videoInfoResponse.body().string();
    }

    private String extractStsFromEmbeddedVideoPage(String embeddedVideoPageHtml) {
        Pattern pattern = Pattern.compile("sts\"\\s*:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(embeddedVideoPageHtml);
        if (matcher.find()) {
            return matcher.group(1);
        } else throw new IllegalStateException("sts wasn't found in the embedded webpage");
    }
}
