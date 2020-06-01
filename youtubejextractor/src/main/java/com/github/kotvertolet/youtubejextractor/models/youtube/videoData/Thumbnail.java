package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Thumbnail implements Parcelable, Serializable {

    public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };
    @SerializedName("thumbnails")
    private List<ThumbnailsItem> thumbnails;

    public Thumbnail() {
    }

    public Thumbnail(List<ThumbnailsItem> thumbnails) {
        this.thumbnails = thumbnails;
    }

    protected Thumbnail(Parcel in) {
        thumbnails = in.createTypedArrayList(ThumbnailsItem.CREATOR);
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(thumbnails);
    }
}