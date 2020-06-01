package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class UrlEndpoint implements Serializable {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "UrlEndpoint{" +
                        "url = '" + url + '\'' +
                        "}";
    }
}
