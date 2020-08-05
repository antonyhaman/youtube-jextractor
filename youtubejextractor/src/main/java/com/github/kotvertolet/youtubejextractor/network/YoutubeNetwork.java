package com.github.kotvertolet.youtubejextractor.network;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeNetwork {

    private final static String YOUTUBE_SITE_URL = "https://www.youtube.com/";
    private IYoutubeApi youtubeApi;

    public YoutubeNetwork(Gson gson) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new UserAgentInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeApi = retrofit.create(IYoutubeApi.class);
    }

    public YoutubeNetwork(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeApi = retrofit.create(IYoutubeApi.class);
    }

    public Response<ResponseBody> getYoutubeVideoInfo(String videoId, String eUrl) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeApi.getVideoInfo(videoId, eUrl));
    }

    public Response<ResponseBody> getYoutubeEmbeddedVideoPage(String videoId) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeApi.getEmbeddedVideoPage(videoId));
    }

    public Response<ResponseBody> getYoutubeVideoPage(String videoId) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeApi.getVideoPage(videoId, "US", 1, "9999999999"));
    }

    public Response<ResponseBody> downloadWebpage(String url) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeApi.getWebPage(url));
    }

    public Response<ResponseBody> getStream(String url) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(youtubeApi.getStream(url));
    }
}