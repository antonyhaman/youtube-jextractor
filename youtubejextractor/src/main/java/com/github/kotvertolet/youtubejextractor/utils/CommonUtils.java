package com.github.kotvertolet.youtubejextractor.utils;

import android.util.Log;

import com.github.kotvertolet.youtubejextractor.BuildConfig;
import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

public class CommonUtils {

    public static Matcher getMatcher(String stringPattern, String stringMatcher) {
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(stringMatcher);
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
