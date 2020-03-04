package com.github.kotvertolet.youtubejextractor.utils;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils {

    public static final String UTF_8 = StandardCharsets.UTF_8.name();

    public static String urlDecode(String urlEncodedStr) {
        try {
            return URLDecoder.decode(urlEncodedStr, UTF_8);
        } catch (UnsupportedEncodingException e) {
            return URLDecoder.decode(urlEncodedStr);
        }
    }

    static String escapeRegExSpecialCharacters(String inputString) {
        final String[] metaCharacters = {"\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<", ">", "-", "&", "%"};

        for (String metaCharacter : metaCharacters) {
            if (inputString.contains(metaCharacter)) {
                inputString = inputString.replace(metaCharacter, "\\" + metaCharacter);
            }
        }
        return inputString;
    }

    public static String urlParamsToJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }

    public static Map<String, String> splitUrlParams(String url) throws ExtractionException {
        final String[] queryParams = url.split("&");
        return splitUrlParams(queryParams);
    }

    public static Map<String, String> splitUrlParams(URL url) throws ExtractionException {
        final String[] queryParams = url.getQuery().split("&");
        return splitUrlParams(queryParams);
    }

    private static Map<String, String> splitUrlParams(String[] queryParamsArr) throws ExtractionException {
        final Map<String, String> queryPairs = new LinkedHashMap<>();
        for (String queryParam : queryParamsArr) {
            final int idx = queryParam.indexOf("=");
            try {
                final String key = idx > 0 ? URLDecoder.decode(queryParam.substring(0, idx), UTF_8) : queryParam;
                if (!queryPairs.containsKey(key)) {
                    final String value = idx > 0 && queryParam.length() > idx + 1
                            ? URLDecoder.decode(queryParam.substring(idx + 1), UTF_8) : null;
                    queryPairs.put(key, value);
                }
            } catch (UnsupportedEncodingException e) {
                throw new ExtractionException(e);
            }
        }
        return queryPairs;
    }
}
