package com.github.kotvertolet.youtubejextractor.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface IYoutubeApi {

    @GET("get_video_info")
    Call<ResponseBody> getVideoInfo(@Query("video_id") String videoId, @Query("eurl") String eurl);

    @GET("embed/{videoId}")
    Call<ResponseBody> getEmbeddedVideoPage(@Path("videoId") String videoId);

    @GET("watch")
    Call<ResponseBody> getVideoPage(@Query("v") String videoId, @Query("gl") String locale,
                                    @Query("has_verified") int hasVerified, @Query("bpctr") String bpctr);

    @GET
    Call<ResponseBody> getWebPage(@Url String url);

    @Streaming
    @GET
    Call<ResponseBody> getStream(@Url String url);
}
