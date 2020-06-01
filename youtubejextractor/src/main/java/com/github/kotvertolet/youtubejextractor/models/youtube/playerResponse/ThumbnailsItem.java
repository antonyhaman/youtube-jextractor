package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class ThumbnailsItem implements Serializable {
    private int width;
    private String url;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
                "ThumbnailsItem{" +
                        "width = '" + width + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
