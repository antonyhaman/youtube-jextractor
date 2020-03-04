package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.kotvertolet.youtubejextractor.models.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.models.VideoStreamItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.AdaptiveFormatItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.FormatsItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.RawStreamingData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogE;

public class StreamingData implements Parcelable {

    public static final Creator<StreamingData> CREATOR = new Creator<StreamingData>() {
        @Override
        public StreamingData createFromParcel(Parcel in) {
            return new StreamingData(in);
        }

        @Override
        public StreamingData[] newArray(int size) {
            return new StreamingData[size];
        }
    };
    @SerializedName("expiresInSeconds")
    private String expiresInSeconds;
    @SerializedName("dashManifestUrl")
    private String dashManifestUrl;
    @SerializedName("hlsManifestUrl")
    private String hlsManifestUrl;
    @SerializedName("formats")
    private List<FormatsItem> formats;
    @SerializedName("probeUrl")
    private String probeUrl;
    @Expose
    private List<AudioStreamItem> audioStreamItems;
    @Expose
    private List<VideoStreamItem> videoStreamItems;

    public StreamingData() {
    }

    public StreamingData(RawStreamingData rawStreamingData) {
        this.expiresInSeconds = rawStreamingData.getExpiresInSeconds();
        this.dashManifestUrl = rawStreamingData.getDashManifestUrl();
        this.hlsManifestUrl = rawStreamingData.getHlsManifestUrl();
        this.probeUrl = rawStreamingData.getProbeUrl();
        this.formats = rawStreamingData.getFormats();
        sortAdaptiveStreamsByType(rawStreamingData.getAdaptiveFormats());
    }

    public StreamingData(String expiresInSeconds, String dashManifestUrl, String hlsManifestUrl, List<AudioStreamItem> audioStreamItems, List<VideoStreamItem> videoStreamItems) {
        this.expiresInSeconds = expiresInSeconds;
        this.dashManifestUrl = dashManifestUrl;
        this.hlsManifestUrl = hlsManifestUrl;
        this.audioStreamItems = audioStreamItems;
        this.videoStreamItems = videoStreamItems;
    }

    protected StreamingData(Parcel in) {
        expiresInSeconds = in.readString();
        dashManifestUrl = in.readString();
        hlsManifestUrl = in.readString();
        audioStreamItems = in.createTypedArrayList(AudioStreamItem.CREATOR);
        videoStreamItems = in.createTypedArrayList(VideoStreamItem.CREATOR);
    }

    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(String expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getDashManifestUrl() {
        return dashManifestUrl;
    }

    public void setDashManifestUrl(String dashManifestUrl) {
        this.dashManifestUrl = dashManifestUrl;
    }

    public String getHlsManifestUrl() {
        return hlsManifestUrl;
    }

    public void setHlsManifestUrl(String hlsManifestUrl) {
        this.hlsManifestUrl = hlsManifestUrl;
    }

    public List<FormatsItem> getFormats() {
        return formats;
    }

    public void setFormats(List<FormatsItem> formats) {
        this.formats = formats;
    }

    public String getProbeUrl() {
        return probeUrl;
    }

    public void setProbeUrl(String probeUrl) {
        this.probeUrl = probeUrl;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(expiresInSeconds);
        dest.writeString(dashManifestUrl);
        dest.writeString(hlsManifestUrl);
        dest.writeList(audioStreamItems);
        dest.writeList(videoStreamItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamingData)) return false;

        StreamingData that = (StreamingData) o;

        if (expiresInSeconds != null ? !expiresInSeconds.equals(that.expiresInSeconds) : that.expiresInSeconds != null)
            return false;
        if (dashManifestUrl != null ? !dashManifestUrl.equals(that.dashManifestUrl) : that.dashManifestUrl != null)
            return false;
        if (hlsManifestUrl != null ? !hlsManifestUrl.equals(that.hlsManifestUrl) : that.hlsManifestUrl != null)
            return false;
        if (audioStreamItems != null ? !audioStreamItems.equals(that.audioStreamItems) : that.audioStreamItems != null)
            return false;
        return videoStreamItems != null ? videoStreamItems.equals(that.videoStreamItems) : that.videoStreamItems == null;
    }

    @Override
    public int hashCode() {
        int result = expiresInSeconds != null ? expiresInSeconds.hashCode() : 0;
        result = 31 * result + (dashManifestUrl != null ? dashManifestUrl.hashCode() : 0);
        result = 31 * result + (hlsManifestUrl != null ? hlsManifestUrl.hashCode() : 0);
        result = 31 * result + (audioStreamItems != null ? audioStreamItems.hashCode() : 0);
        result = 31 * result + (videoStreamItems != null ? videoStreamItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RawStreamingData{" +
                "expiresInSeconds='" + expiresInSeconds + '\'' +
                ", dashManifestUrl='" + dashManifestUrl + '\'' +
                ", hlsManifestUrl='" + hlsManifestUrl + '\'' +
                ", audioStreamItems=" + audioStreamItems +
                ", videoStreamItems=" + videoStreamItems +
                '}';
    }

    private void sortAdaptiveStreamsByType(List<AdaptiveFormatItem> adaptiveFormats) {
        List<VideoStreamItem> videoStreamItems = new ArrayList<>();
        List<AudioStreamItem> audioStreamItems = new ArrayList<>();

        for (AdaptiveFormatItem adaptiveFormat : adaptiveFormats) {
            String mimeType = adaptiveFormat.getMimeType();
            if (mimeType.contains("audio")) {
                audioStreamItems.add(new AudioStreamItem(adaptiveFormat));
            } else if (mimeType.contains("video")) {
                videoStreamItems.add(new VideoStreamItem(adaptiveFormat));
            } else {
                LogE(getClass().getSimpleName(), "Unknown stream type found: " + mimeType);
            }
        }
        this.audioStreamItems = audioStreamItems;
        this.videoStreamItems = videoStreamItems;
    }
}