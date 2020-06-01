package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class VideostatsWatchtimeUrl implements Serializable {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        return
                "VideostatsWatchtimeUrl{" +
                        "baseUrl = '" + baseUrl + '\'' +
                        "}";
    }
}
