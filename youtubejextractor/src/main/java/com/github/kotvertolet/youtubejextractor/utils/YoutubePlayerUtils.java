package com.github.kotvertolet.youtubejextractor.utils;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class YoutubePlayerUtils {

    /**
     * Extracts url of js player from embedded youtube page
     *
     * @param videoPageHtml youtube page
     * @return returns player url (like this one - 'https://www.youtube.com/yts/jsbin/player-vflkwPKV5/en_US/base.js')
     * @throws ExtractionException if there is no video player url in html code which means that
     *                             there is some problem with regular expression or html code provided
     */
    public static String getJsPlayerUrl(String videoPageHtml) throws ExtractionException {
        Pattern pattern = Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")");
        Matcher matcher = pattern.matcher(videoPageHtml);

        if (matcher.find()) {
            String match = matcher.group(1);
            // Removing backslashes
            match = match.replaceAll("\\\\", "");
            // Removing leading and trailing quotes
            return match.replaceAll("^\"|\"$", "");
        } else
            throw new ExtractionException("No js video player url found");
    }

    /**
     * Downloads JS youtube video player
     *
     * @param playerUrl player url
     * @return js code of the player
     * @throws YoutubeRequestException if the player url is invalid or there is connection problems
     */
    public static String downloadJsPlayer(String playerUrl) throws YoutubeRequestException {
        try {
            Response<ResponseBody> responseBody = YoutubeSiteNetwork.getInstance().downloadWebpage(playerUrl);
            return responseBody.body().string();
        } catch (IOException | NullPointerException e) {
            throw new YoutubeRequestException("Error while downloading youtube js video player", e);
        }
    }
}
