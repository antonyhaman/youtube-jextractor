package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.RawStreamingData;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class YoutubeVideoData implements Parcelable, Serializable {

    public static final Creator<YoutubeVideoData> CREATOR = new Creator<YoutubeVideoData>() {
        @Override
        public YoutubeVideoData createFromParcel(Parcel in) {
            return new YoutubeVideoData(in);
        }

        @Override
        public YoutubeVideoData[] newArray(int size) {
            return new YoutubeVideoData[size];
        }
    };
    @SerializedName("videoDetails")
    private VideoDetails videoDetails;
    @SerializedName("streamingData")
    private StreamingData streamingData;

    public YoutubeVideoData() {
    }

    public YoutubeVideoData(VideoDetails videoDetails, RawStreamingData streamingData) {
        this.videoDetails = videoDetails;
        this.streamingData = new StreamingData(streamingData);
    }

    protected YoutubeVideoData(Parcel in) {
        videoDetails = in.readParcelable(VideoDetails.class.getClassLoader());
        streamingData = in.readParcelable(StreamingData.class.getClassLoader());
    }

    public VideoDetails getVideoDetails() {
        return videoDetails;
    }

    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public StreamingData getStreamingData() {
        return streamingData;
    }

    public void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }

    @Override
    public String toString() {
        return "YoutubeVideoData{" +
                "videoDetails=" + videoDetails +
                ", streamingData=" + streamingData +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YoutubeVideoData)) return false;

        YoutubeVideoData that = (YoutubeVideoData) o;

        if (!videoDetails.equals(that.videoDetails)) return false;
        return streamingData.equals(that.streamingData);
    }

    @Override
    public int hashCode() {
        int result = videoDetails.hashCode();
        result = 31 * result + streamingData.hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(videoDetails, flags);
        dest.writeParcelable(streamingData, flags);
    }
}