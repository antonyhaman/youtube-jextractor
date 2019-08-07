package com.github.kotvertolet.youtubejextractor.utils;


import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

import java.util.ArrayList;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.getMatcher;

public class ExtractionUtils {

    private ArrayList<String> patterns = new ArrayList<>();
    {
        patterns.add("\\b\\[cs\\]\\s*&&\\s*[adf]\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("\\b[a-zA-Z0-9]+\\s*&&\\s*[a-zA-Z0-9]+\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("(?<sig>[a-zA-Z0-9$]+)\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        // Obsolete patterns
        patterns.add("([\"\\'])signature\\1\\s*,\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("\\.sig\\|\\|(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("yt\\.akamaized\\.net/\\)\\s*\\|\\|\\s*.*?\\s*c\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        patterns.add("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*\\([^)]*\\)\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
    }

    public static boolean isVideoAgeRestricted(String videoPageHtml) {
        return videoPageHtml.contains("player-age-gate-content\">");
    }

    public static String extractStsFromVideoPageHtml(String embeddedVideoPageHtml) throws ExtractionException {
        Matcher matcher = getMatcher("sts\"\\s*:\\s*(\\d+)", embeddedVideoPageHtml);
        if (matcher.find()) {
            return matcher.group(1);
        } else
            throw new ExtractionException("Sts param wasn't found in the embedded player webpage code");
    }

    public String extractYoutubeVideoPlayerCode(String playerUrl) throws YoutubeRequestException, ExtractionException, SignatureDecryptionException {
        playerUrl = preparePlayerUrl(playerUrl);
        Matcher matcher = getMatcher("([a-z]+)$", playerUrl);
        if (!matcher.find()) {
            throw new ExtractionException("Cannot identify player type by url: " + playerUrl);
        }
        String playerType = matcher.group();
        switch (playerType) {
            case "js":
                return YoutubePlayerUtils.downloadJsPlayer(playerUrl);
            //TODO: This might be not necessary as swf player is outdated and not used anymore
            case "swf":
                throw new UnsupportedOperationException("Swf player type is not supported");
            default:
                throw new UnsupportedOperationException("Invalid player type: " + playerType);
        }
    }

    public String extractDecryptFunctionName(String playerCode) throws ExtractionException {
        String signatureDecryptFunctionName;
        for (String pattern : patterns) {
            Matcher matcher = getMatcher(pattern, playerCode);
            if (matcher.find()) {
                signatureDecryptFunctionName = matcher.group(1);
                return signatureDecryptFunctionName;
            }
        }
        throw new ExtractionException("Cannot find required JS function in JS video player code");
    }

    private String preparePlayerUrl(String playerUrl) throws SignatureDecryptionException {
        if (playerUrl.isEmpty()) {
            throw new SignatureDecryptionException("Cannot decrypt signature without player_url!");
        }
        if (playerUrl.startsWith("//")) {
            playerUrl = "https:" + playerUrl;
        }
        Pattern pattern = Pattern.compile("https?://");
        Matcher matcher = pattern.matcher(playerUrl);
        if (!matcher.matches()) {
            playerUrl = "https://www.youtube.com" + playerUrl;
        } else
            throw new SignatureDecryptionException("Cannot create proper player url with url: " + playerUrl);
        return playerUrl;
    }
}