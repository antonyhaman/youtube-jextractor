package com.github.kotvertolet.youtubejextractor.network;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoogleVideoNetwork {

    private final static String BASE_URL = "https://video.google.com/";
    private IGoogleVideoApi googleVideoApi;

    public GoogleVideoNetwork(Gson gson) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new UserAgentInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        googleVideoApi = retrofit.create(IGoogleVideoApi.class);
    }

    public Response<ResponseBody> getSubtitlesList(String videoId) throws IOException {
        return googleVideoApi.getSubtitles("list", videoId, null).execute();
    }

    public Response<ResponseBody> getSubtitles(String videoId, String langCode) throws IOException {
        return googleVideoApi.getSubtitles("track", videoId, langCode).execute();
    }
}
