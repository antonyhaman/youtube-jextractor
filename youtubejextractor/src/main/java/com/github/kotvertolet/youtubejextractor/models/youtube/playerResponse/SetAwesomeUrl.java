package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class SetAwesomeUrl {
    private String baseUrl;
    private int elapsedMediaTimeSeconds;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public int getElapsedMediaTimeSeconds() {
        return elapsedMediaTimeSeconds;
    }

    public void setElapsedMediaTimeSeconds(int elapsedMediaTimeSeconds) {
        this.elapsedMediaTimeSeconds = elapsedMediaTimeSeconds;
    }

    @Override
    public String toString() {
        return
                "SetAwesomeUrl{" +
                        "baseUrl = '" + baseUrl + '\'' +
                        ",elapsedMediaTimeSeconds = '" + elapsedMediaTimeSeconds + '\'' +
                        "}";
    }
}
