package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Thumbnail {

    @SerializedName("thumbnails")
    private List<ThumbnailsItem> thumbnails;

    public List<ThumbnailsItem> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<ThumbnailsItem> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return
                "Thumbnail{" +
                        "thumbnails = '" + thumbnails + '\'' +
                        "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thumbnail)) return false;

        Thumbnail thumbnail = (Thumbnail) o;

        return thumbnails != null ? thumbnails.equals(thumbnail.thumbnails) : thumbnail.thumbnails == null;
    }

    @Override
    public int hashCode() {
        return thumbnails != null ? thumbnails.hashCode() : 0;
    }
}