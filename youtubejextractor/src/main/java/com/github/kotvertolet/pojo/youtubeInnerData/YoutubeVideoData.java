package com.github.kotvertolet.pojo.youtubeInnerData;

import com.google.gson.annotations.SerializedName;


public class YoutubeVideoData {

    @SerializedName("videoDetails")
    private VideoDetails videoDetails;

    @SerializedName("streamingData")
    private StreamingData streamingData;

    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public VideoDetails getVideoDetails() {
        return videoDetails;
    }

    public void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }

    public StreamingData getStreamingData() {
        return streamingData;
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
}