package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import com.github.kotvertolet.youtubejextractor.models.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.models.VideoStreamItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StreamingData {

    @SerializedName("expiresInSeconds")
    private String expiresInSeconds;
    @Expose
    private List<AudioStreamItem> audioStreamItems;
    @Expose
    private List<VideoStreamItem> videoStreamItems;

    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(String expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    public List<AudioStreamItem> getAudioStreamItems() {
        return audioStreamItems;
    }

    public void setAudioStreamItems(List<AudioStreamItem> audioStreamItems) {
        this.audioStreamItems = audioStreamItems;
    }

    public List<VideoStreamItem> getVideoStreamItems() {
        return videoStreamItems;
    }

    public void setVideoStreamItems(List<VideoStreamItem> videoStreamItems) {
        this.videoStreamItems = videoStreamItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamingData)) return false;

        StreamingData that = (StreamingData) o;

        if (expiresInSeconds != null ? !expiresInSeconds.equals(that.expiresInSeconds) : that.expiresInSeconds != null)
            return false;
        if (audioStreamItems != null ? !audioStreamItems.equals(that.audioStreamItems) : that.audioStreamItems != null)
            return false;
        return videoStreamItems != null ? videoStreamItems.equals(that.videoStreamItems) : that.videoStreamItems == null;
    }

    @Override
    public int hashCode() {
        int result = expiresInSeconds != null ? expiresInSeconds.hashCode() : 0;
        result = 31 * result + (audioStreamItems != null ? audioStreamItems.hashCode() : 0);
        result = 31 * result + (videoStreamItems != null ? videoStreamItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StreamingData{" +
                "expiresInSeconds='" + expiresInSeconds + '\'' +
                ", audioStreamItems=" + audioStreamItems +
                ", videoStreamItems=" + videoStreamItems +
                '}';
    }
}