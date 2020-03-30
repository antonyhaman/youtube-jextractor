package com.github.kotvertolet.youtubejextractor.network;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeSiteNetwork {

    private final static String YOUTUBE_SITE_URL = "https://www.youtube.com/";
    private YoutubeSiteApi youtubeSiteApi;

    public YoutubeSiteNetwork(Gson gson) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeSiteApi = retrofit.create(YoutubeSiteApi.class);
    }

    public YoutubeSiteNetwork(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeSiteApi = retrofit.create(YoutubeSiteApi.class);
    }

    public Response<ResponseBody> getYoutubeVideoInfo(String videoId, String eUrl) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeSiteApi.getVideoInfo(videoId, eUrl));
    }

    public Response<ResponseBody> getYoutubeEmbeddedVideoPage(String videoId) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeSiteApi.getEmbeddedVideoPage(videoId));
    }

    public Response<ResponseBody> getYoutubeVideoPage(String videoId) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeSiteApi.getVideoPage(videoId, "US", 1, "9999999999"));
    }

    public Response<ResponseBody> downloadWebpage(String url) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeSiteApi.getWebPage(url));
    }

    public Response<ResponseBody> getStream(String url) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeSiteApi.getStream(url));
    }
}