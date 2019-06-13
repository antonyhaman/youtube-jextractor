package com.github.kotvertolet.youtubejextractor.exception;

public class YoutubeNetworkCallException extends Exception {

    public YoutubeNetworkCallException(String message) {
        super(message);
    }

    public YoutubeNetworkCallException(String message, Throwable cause) {
        super(message, cause);
    }

    public YoutubeNetworkCallException(Throwable cause) {
        super(cause);
    }
}
