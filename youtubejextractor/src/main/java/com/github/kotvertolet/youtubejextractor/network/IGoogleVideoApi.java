package com.github.kotvertolet.youtubejextractor.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGoogleVideoApi {

    @GET("timedtext")
    Call<ResponseBody> getSubtitles(@Query("type") String type, @Query("v") String videoId, @Query("lang") String langCode);
}
