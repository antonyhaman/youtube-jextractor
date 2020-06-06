package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.YoutubeVideoData;

public interface JExtractorCallback {

    void onSuccess(YoutubeVideoData videoData);

    void onNetworkException(YoutubeRequestException e);

    void onError(Exception exception);
}
