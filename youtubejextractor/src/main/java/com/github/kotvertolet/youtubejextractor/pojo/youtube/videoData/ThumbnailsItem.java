package com.github.kotvertolet.youtubejextractor.pojo.youtube.videoData;

import com.google.gson.annotations.SerializedName;


public class ThumbnailsItem {

    @SerializedName("width")
    private int width;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThumbnailsItem)) return false;

        ThumbnailsItem that = (ThumbnailsItem) o;

        if (width != that.width) return false;
        if (height != that.height) return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + height;
        return result;
    }
}