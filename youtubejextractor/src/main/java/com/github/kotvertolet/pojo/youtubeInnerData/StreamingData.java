package com.github.kotvertolet.pojo.youtubeInnerData;

import com.github.kotvertolet.pojo.StreamItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class StreamingData {

    @SerializedName("expiresInSeconds")
    private String expiresInSeconds;

    @Expose
    private List<StreamItem> streamItems;

    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(String expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    public List<StreamItem> getStreamItems() {
        return streamItems;
    }

    public void setStreamItems(List<StreamItem> streamItems) {
        this.streamItems = streamItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamingData)) return false;

        StreamingData that = (StreamingData) o;

        if (expiresInSeconds != null ? !expiresInSeconds.equals(that.expiresInSeconds) : that.expiresInSeconds != null)
            return false;
        return streamItems != null ? streamItems.equals(that.streamItems) : that.streamItems == null;
    }

    @Override
    public int hashCode() {
        int result = expiresInSeconds != null ? expiresInSeconds.hashCode() : 0;
        result = 31 * result + (streamItems != null ? streamItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StreamingData{" +
                "expiresInSeconds='" + expiresInSeconds + '\'' +
                ", streamItems=" + streamItems +
                '}';
    }
}