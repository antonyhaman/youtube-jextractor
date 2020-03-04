package com.github.kotvertolet.youtubejextractor.utils;


import android.util.Log;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class ExtractionUtils {

    public static boolean isVideoAgeRestricted(String videoPageHtml) {
        return videoPageHtml.contains("player-age-gate-content\">");
    }

    public static String extractStsFromVideoPageHtml(String embeddedVideoPageHtml) throws ExtractionException {
        Pattern pattern = Pattern.compile("sts\"\\s*:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(embeddedVideoPageHtml);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            Log.i(ExtractionUtils.class.getSimpleName(), "Sts param wasn't found in the embedded player webpage code");
            return "";
        }
    }

    public String extractYoutubeVideoPlayerCode(String playerUrl) throws YoutubeRequestException, ExtractionException, SignatureDecryptionException {
        playerUrl = preparePlayerUrl(playerUrl);

        Pattern pattern = Pattern.compile("([a-z]+)$");
        Matcher matcher = pattern.matcher(playerUrl);
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

        Pattern newPattern1 = Pattern.compile("\\b\\[cs\\]\\s*&&\\s*[adf]\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern newPattern2 = Pattern.compile("\\b[a-zA-Z0-9]+\\s*&&\\s*[a-zA-Z0-9]+\\.set\\([^,]+\\s*,\\s*encodeURIComponent\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern newPattern3 = Pattern.compile("\\b(?<sig>[a-zA-Z0-9$]{2})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        Pattern newPattern4 = Pattern.compile("(?<sig>[a-zA-Z0-9$]+)\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        // Obsolete patterns
        Pattern obsoletePattern1 = Pattern.compile("([\"\\'])signature\\1\\s*,\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern2 = Pattern.compile("\\.sig\\|\\|(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern3 = Pattern.compile("yt\\.akamaized\\.net/\\)\\s*\\|\\|\\s*.*?\\s*c\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern4 = Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern5 = Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*\\([^)]*\\)\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");

        String signatureDecryptFunctionName = null;
        Matcher matcher;

        List<Pattern> patterns = asList(
                newPattern1,
                newPattern2,
                newPattern3,
                newPattern4
        );
        Iterator<Pattern> iter = patterns.iterator();

        while (signatureDecryptFunctionName == null && iter.hasNext()) {
            matcher = iter.next().matcher(playerCode);
            if (matcher.find()) {
                // Restarting the search
                matcher.find(0);
                signatureDecryptFunctionName = matcher.group(1);
            }
        }

        if (signatureDecryptFunctionName == null) {
            throw new ExtractionException("Cannot find required JS function in JS video player code");
        }

//        if (newPattern1.matcher(playerCode).find()) {
//            matcher = newPattern1.matcher(playerCode);
//        } else if (newPattern2.matcher(playerCode).find()) {
//            matcher = newPattern2.matcher(playerCode);
//        } else if (obsoletePattern1.matcher(playerCode).find()) {
//            matcher = obsoletePattern1.matcher(playerCode);
//        } else if (obsoletePattern2.matcher(playerCode).find()) {
//            matcher = obsoletePattern2.matcher(playerCode);
//        } else if (obsoletePattern3.matcher(playerCode).find()) {
//            matcher = obsoletePattern3.matcher(playerCode);
//        } else if (obsoletePattern4.matcher(playerCode).find()) {
//            matcher = obsoletePattern4.matcher(playerCode);
//        } else if (obsoletePattern5.matcher(playerCode).find()) {
//            matcher = obsoletePattern5.matcher(playerCode);
//        } else
//            throw new ExtractionException("Cannot find required JS function in JS video player code");
//        // Restarting the search
//        matcher.find(0);
//        signatureDecryptFunctionName = matcher.group(1);
        return signatureDecryptFunctionName;
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
