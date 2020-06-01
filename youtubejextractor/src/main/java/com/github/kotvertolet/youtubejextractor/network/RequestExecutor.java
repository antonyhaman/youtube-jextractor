package com.github.kotvertolet.youtubejextractor.network;

import android.util.Log;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class RequestExecutor {

    private String TAG = RequestExecutor.class.getSimpleName();
    private int attemptsCounter = 0;
    private Response<ResponseBody> response = null;

    public Response<ResponseBody> executeWithRetry(Call<ResponseBody> httpCall) throws YoutubeRequestException {
        try {
            response = httpCall.execute();
        } catch (IOException e) {
            if (attemptsCounter < 2) {
                Log.i(TAG, "Attempting to receive successful response, attempt #" + attemptsCounter);
                attemptsCounter++;
                executeWithRetry(httpCall.clone());
            } else throw new YoutubeRequestException(String.format("Could not receive successful" +
                    "response after 3 attempts, check the internet connection, http code was: '%s'", response.code()), e);
        }
        return response;
    }
}
