package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.models.newModels.VideoPlayerConfig;

public interface JExtractorCallback {

    void onSuccess(VideoPlayerConfig videoData);

    void onNetworkException(YoutubeRequestException e);

    void onError(Exception exception);
}
