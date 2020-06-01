package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class Embed implements Serializable {

    private int width;
    private String flashUrl;
    private String flashSecureUrl;
    private String iframeUrl;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFlashUrl() {
        return flashUrl;
    }

    public void setFlashUrl(String flashUrl) {
        this.flashUrl = flashUrl;
    }

    public String getFlashSecureUrl() {
        return flashSecureUrl;
    }

    public void setFlashSecureUrl(String flashSecureUrl) {
        this.flashSecureUrl = flashSecureUrl;
    }

    public String getIframeUrl() {
        return iframeUrl;
    }

    public void setIframeUrl(String iframeUrl) {
        this.iframeUrl = iframeUrl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return
                "Embed{" +
                        "width = '" + width + '\'' +
                        ",flashUrl = '" + flashUrl + '\'' +
                        ",flashSecureUrl = '" + flashSecureUrl + '\'' +
                        ",iframeUrl = '" + iframeUrl + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
