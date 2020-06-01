package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ThumbnailsItem implements Parcelable, Serializable {

    public static final Creator<ThumbnailsItem> CREATOR = new Creator<ThumbnailsItem>() {
        @Override
        public ThumbnailsItem createFromParcel(Parcel in) {
            return new ThumbnailsItem(in);
        }

        @Override
        public ThumbnailsItem[] newArray(int size) {
            return new ThumbnailsItem[size];
        }
    };
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("url")
    private String url;

    public ThumbnailsItem() {
    }

    public ThumbnailsItem(int width, int height, String url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    protected ThumbnailsItem(Parcel in) {
        width = in.readInt();
        height = in.readInt();
        url = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(url);
    }
}