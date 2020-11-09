package com.github.kotvertolet.youtubejextractor.utils;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.network.YoutubeNetwork;
import com.google.code.regexp.Pattern;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.matchWithPatterns;

public class YoutubePlayerUtils {

    private YoutubeNetwork youtubeNetwork;

    public YoutubePlayerUtils(YoutubeNetwork youtubeNetwork) {
        this.youtubeNetwork = youtubeNetwork;
    }

    /**
     * Extracts url of js player from embedded youtube page
     *
     * @param videoPageHtml youtube page
     * @return returns player url (like this one - 'https://www.youtube.com/yts/jsbin/player-vflkwPKV5/en_US/base.js')
     * @throws ExtractionException if there is no video player url in html code which means that
     *                             there is some problem with regular expression or html code provided
     */
    public String getJsPlayerUrl(String videoPageHtml) throws ExtractionException {
        //Pattern pattern = Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")");
        List<Pattern> patterns = Arrays.asList(
                Pattern.compile("<script[^>]+\\bsrc=(\"[^\"]+\")[^>]+\\bname=[\"']player_ias/base"),
                Pattern.compile("\"jsUrl\"\\s*:\\s*(\"[^\"]+\")"),
                Pattern.compile("\"assets\":.+?\"js\":\\s*(\"[^\"]+\")"));
        String jsPlayerUrl = matchWithPatterns(patterns, videoPageHtml);

        if (jsPlayerUrl != null) {
            jsPlayerUrl = jsPlayerUrl.replaceAll("\\\\", "");
            // Removing leading and trailing quotes
            return jsPlayerUrl.replaceAll("^\"|\"$", "");
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
    public String downloadJsPlayer(String playerUrl) throws YoutubeRequestException {
        try {
            Response<ResponseBody> responseBody = youtubeNetwork.downloadWebpage(playerUrl);
            return responseBody.body().string();
        } catch (IOException | NullPointerException e) {
            throw new YoutubeRequestException("Error while downloading youtube js video player", e);
        }
    }
}
