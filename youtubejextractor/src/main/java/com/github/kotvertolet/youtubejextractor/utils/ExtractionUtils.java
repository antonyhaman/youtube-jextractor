package com.github.kotvertolet.youtubejextractor.utils;


import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

import java.util.List;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogI;
import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.matchWithPatterns;
import static java.util.Arrays.asList;

public class ExtractionUtils {
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36";
    public static final String loginCookie = "YSC=yNxWJf1cSa4;VISITOR_INFO1_LIVE=sgfw6SW98bw;GPS=1;SID=2wcm6biEhIBQ7mAlI74wOiKiyb_qgHjGqRda45ja9Uo-R_YGPv7BsMw9LxwWxijRYBbl9Q.;__Secure-3PSID=2wcm6biEhIBQ7mAlI74wOiKiyb_qgHjGqRda45ja9Uo-R_YG7NLzd6XbeKd5v4FdcW0fFw.;HSID=AZUFTUl5YDEbXnxXz;SSID=Al9RcjJhYjDs0mH_8;APISID=gno4Jw69CDDSLOoA/Au2BTJQ9vzFfv6jDi;SAPISID=CS66fqRwUvDy_8qr/ASZJ0MtESshD5jMOH;__Secure-3PAPISID=CS66fqRwUvDy_8qr/ASZJ0MtESshD5jMOH;CONSENT=YES+PK.en+202010;LOGIN_INFO=AFmmF2swRQIhAMeOhq-bNVUVUTnNdJnT37v__UYLzOmcDurH2rGtqiqGAiB7hbo1chMtmz5Bn52kKsnRQl6CsWjy8AaWsDOmPQbh1Q:QUQ3MjNmejE5SmExRzFjamk2Wi0xZDJnNW5VU3gwTUVjdjNCYjFGZUo4R2RHeVZfWEFLM2hSWlNXUGpmdzNuemtSUm5MMWJfLVBiMERzemhFQ3ZCMEFjQm1Ud0M4bGpWMmdiTUtYMHpFcmo2WVY2cklBVDJfSWZjMUphMGZQMThCTmZab3J2ZjhYNmNlLXpuRkNSMjZtOXBWRFpraWN0VHEwZTJFLWZVLUF4YmlJb3hrZzVHNktwc05KRUV5aXhJSzRsYzV2N2REVWhW;SIDCC=AJi4QfHl4irM7tcfniTbzgdTmGax9V8uBSUj8uNcPKqSWJJ00Qyl9jSUL1Yhz5WmPl_AmH2XeQ;__Secure-3PSIDCC=AJi4QfFiBQavkEX4ZGQDhud12UroBrzENEaMttnSkCIMUfwlwjtzs5TUWxuVCE-HW2emhh4o";
    private YoutubePlayerUtils youtubePlayerUtils;

    public ExtractionUtils(YoutubePlayerUtils youtubePlayerUtils) {
        this.youtubePlayerUtils = youtubePlayerUtils;
    }

    public boolean isVideoAgeRestricted(String videoPageHtml) {
        Pattern ageGatePattern = Pattern.compile("[\"\\']status[\"\\']\\s*:\\s*[\"\\']LOGIN_REQUIRED");
        return ageGatePattern.matcher(videoPageHtml).find() || videoPageHtml.contains("LOGIN_REQUIRED");
    }

    public String extractStsFromVideoPageHtml(String embeddedVideoPageHtml) {
        Pattern pattern = Pattern.compile("sts\"\\s*:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(embeddedVideoPageHtml);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            LogI(ExtractionUtils.class.getSimpleName(), "Sts param wasn't found in the embedded player webpage code");
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
                return youtubePlayerUtils.downloadJsPlayer(playerUrl);
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
        Pattern newPattern3 = Pattern.compile("(?:\\b|[^a-zA-Z0-9$])(?<sig>[a-zA-Z0-9$]{2})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        //Pattern newPattern3 = Pattern.compile("\\b(?<sig>[a-zA-Z0-9$]{2})\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        Pattern newPattern4 = Pattern.compile("(?<sig>[a-zA-Z0-9$]+)\\s*=\\s*function\\(\\s*a\\s*\\)\\s*\\{\\s*a\\s*=\\s*a\\.split\\(\\s*\"\"\\s*\\)");
        // Obsolete patterns
        Pattern obsoletePattern1 = Pattern.compile("([\"\\'])signature\\1\\s*,\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern2 = Pattern.compile("\\.sig\\|\\|(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern3 = Pattern.compile("yt\\.akamaized\\.net/\\)\\s*\\|\\|\\s*.*?\\s*c\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern4 = Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*(?:encodeURIComponent\\s*\\()?\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        Pattern obsoletePattern5 = Pattern.compile("\\bc\\s*&&\\s*d\\.set\\([^,]+\\s*,\\s*\\([^)]*\\)\\s*\\(\\s*(?<sig>[a-zA-Z0-9$]+)\\(");
        List<Pattern> patterns = asList(
                newPattern1,
                newPattern2,
                newPattern3,
                newPattern4,
                obsoletePattern1,
                obsoletePattern2,
                obsoletePattern3,
                obsoletePattern4,
                obsoletePattern5
        );
        String signatureDecryptFunctionName = matchWithPatterns(patterns, playerCode);
        if (signatureDecryptFunctionName == null) {
            throw new ExtractionException("Cannot find required JS function in JS video player code");
        }
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
