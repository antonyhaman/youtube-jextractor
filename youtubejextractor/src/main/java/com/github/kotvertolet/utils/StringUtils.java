package com.github.kotvertolet.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils {

    static String escapeRegExSpecialCharacters(String inputString) {
        final String[] metaCharacters = {"\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "|", "<", ">", "-", "&", "%"};

        for (String metaCharacter : metaCharacters) {
            if (inputString.contains(metaCharacter)) {
                inputString = inputString.replace(metaCharacter, "\\" + metaCharacter);
            }
        }
        return inputString;
    }

    public static Map<String, String> splitUrlParams(String url) throws UnsupportedEncodingException {
        final String[] queryParams = url.split("&");
        return splitUrlParams(queryParams);
    }

    public static Map<String, String> splitUrlParams(URL url) throws UnsupportedEncodingException {
        final String[] queryParams = url.getQuery().split("&");
        return splitUrlParams(queryParams);
    }

    private static Map<String, String> splitUrlParams(String[] queryParamsArr) throws UnsupportedEncodingException {
        final Map<String, String> queryPairs = new LinkedHashMap<>();
        for (String queryParam : queryParamsArr) {
            final int idx = queryParam.indexOf("=");
            final String key = idx > 0 ? URLDecoder.decode(queryParam.substring(0, idx), "UTF-8") : queryParam;
            if (!queryPairs.containsKey(key)) {
                final String value = idx > 0 && queryParam.length() > idx + 1 ? URLDecoder.decode(queryParam.substring(idx + 1), "UTF-8") : null;
                queryPairs.put(key, value);
            }
        }
        return queryPairs;
    }
}
