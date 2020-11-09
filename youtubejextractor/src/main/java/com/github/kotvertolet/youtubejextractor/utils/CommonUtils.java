package com.github.kotvertolet.youtubejextractor.utils;

import android.util.Log;

import com.github.kotvertolet.youtubejextractor.BuildConfig;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

import java.util.Iterator;
import java.util.List;

public class CommonUtils {

    public static Matcher getMatcher(String stringPattern, String stringMatcher) {
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(stringMatcher);
    }

    public static String matchWithPatterns(List<Pattern> patterns, String inputString) {
        String outputString = null;
        Matcher matcher;
        Iterator<Pattern> iter = patterns.iterator();
        while (outputString == null && iter.hasNext()) {
            matcher = iter.next().matcher(inputString);
            if (matcher.find()) {
                // Restarting the search
                matcher.find(0);
                outputString = matcher.group(1);
            }
        }
        return outputString;
    }

    public static void LogI(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message);
        }
    }

    public static void LogE(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }
}
