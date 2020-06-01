package com.github.kotvertolet.youtubejextractor.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UserAgentInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36" +
                " (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36";
        Request requestWithUserAgent = originalRequest.newBuilder()
                .addHeader("User-Agent", userAgent)
                .addHeader("Accept", "*/*")
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
