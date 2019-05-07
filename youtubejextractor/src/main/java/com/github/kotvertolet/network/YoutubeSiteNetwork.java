package com.github.kotvertolet.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeSiteNetwork {

    private Retrofit retrofit;
    private YoutubeSiteApi youtubeSiteApi;
    private static YoutubeSiteNetwork instance;
    private final static String YOUTUBE_SITE_URL = "https://www.youtube.com/";

    private YoutubeSiteNetwork() {
        Gson gson = new GsonBuilder()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeSiteApi = retrofit.create(YoutubeSiteApi.class);
    }

    public static synchronized YoutubeSiteNetwork getInstance() {
        if (instance == null) {
            instance = new YoutubeSiteNetwork();
            return instance;
        } else return instance;
    }

    public Response<ResponseBody> getYoutubeVideoInfo(String videoId, String eUrl) throws IOException {
        return youtubeSiteApi.getVideoInfo(videoId, eUrl).execute();
    }

    public Response<ResponseBody> getYoutubeEmbeddedWebpage(String videoId) throws IOException {
        return youtubeSiteApi.getEmbeddedWebPage(videoId).execute();
    }

    public Response<ResponseBody> getYoutubeEmbeddedWebpage() throws IOException {
        return youtubeSiteApi.getEmbeddedWebPage().execute();
    }

    public Response<ResponseBody> downloadWebpage(String url) throws IOException {
        return youtubeSiteApi.getWebPage(url).execute();
    }

    public Response<ResponseBody> getStream(String url) throws IOException {
        return youtubeSiteApi.getStream(url).execute();
    }
}
