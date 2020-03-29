package com.github.kotvertolet.youtubejextractor.network;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeSiteNetwork {

    private final static String YOUTUBE_SITE_URL = "https://www.youtube.com/";
    private static YoutubeSiteNetwork instance;
    private YoutubeSiteApi youtubeSiteApi;
    private int attemptsCounter = 0;

    private YoutubeSiteNetwork(Gson gson) {
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

    private YoutubeSiteNetwork(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YOUTUBE_SITE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeSiteApi = retrofit.create(YoutubeSiteApi.class);
    }

    public static YoutubeSiteNetwork getInstance(Gson gson) {
        if (instance == null) {
            instance = new YoutubeSiteNetwork(gson);
            return instance;
        } else return instance;
    }

    public static YoutubeSiteNetwork getInstance(Gson gson, OkHttpClient client) {
        if (instance == null) {
            instance = new YoutubeSiteNetwork(gson, client);
            return instance;
        } else return instance;
    }

    public Response<ResponseBody> getYoutubeVideoInfo(String videoId, String eUrl) throws YoutubeRequestException {
        return executeWithRetry(youtubeSiteApi.getVideoInfo(videoId, eUrl));
    }

    public Response<ResponseBody> getYoutubeEmbeddedVideoPage(String videoId) throws YoutubeRequestException {
        return executeWithRetry(youtubeSiteApi.getEmbeddedVideoPage(videoId));
    }

    public Response<ResponseBody> getYoutubeVideoPage(String videoId) throws YoutubeRequestException {
        return executeWithRetry(youtubeSiteApi.getVideoPage(videoId, "US", 1, "9999999999"));
    }

    public Response<ResponseBody> downloadWebpage(String url) throws YoutubeRequestException {
        return executeWithRetry(youtubeSiteApi.getWebPage(url));
    }

    public Response<ResponseBody> getStream(String url) throws YoutubeRequestException {
        return executeWithRetry(youtubeSiteApi.getStream(url));
    }

    private Response<ResponseBody> executeWithRetry(Call<ResponseBody> httpCall) throws YoutubeRequestException {
        Response<ResponseBody> response;
        try {
            response = httpCall.execute();
            while (!response.isSuccessful() && attemptsCounter <= 2) {
                response = httpCall.clone().execute();
                attemptsCounter++;
            }
            if (!response.isSuccessful()) {
                String url = httpCall.request().url().toString();
                int code = response.code();
                throw new IOException(
                        String.format("Could not receive successful response after 3 attempts check the internet connection," +
                                " http code was: '%s', url: '%s'", code, url));
            } else {
                attemptsCounter = 0;
                return response;
            }
        } catch (IOException e) {
            attemptsCounter = 0;
            throw new YoutubeRequestException(e);
        }
    }
}
