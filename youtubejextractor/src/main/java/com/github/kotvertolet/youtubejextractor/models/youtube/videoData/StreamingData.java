package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.github.kotvertolet.youtubejextractor.models.AdaptiveVideoStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.AdaptiveStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.RawStreamingData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.LogE;

public class StreamingData implements Parcelable, Serializable {

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
    private List<MuxedStream> muxedStreams;
    @SerializedName("probeUrl")
    private String probeUrl;
    @Expose
    private List<AdaptiveAudioStream> adaptiveAudioStreams = new ArrayList<>();
    @Expose
    private List<AdaptiveVideoStream> adaptiveVideoStreams = new ArrayList<>();

    public StreamingData() {
    }

    public StreamingData(RawStreamingData rawStreamingData) {
        this.expiresInSeconds = rawStreamingData.getExpiresInSeconds();
        this.dashManifestUrl = rawStreamingData.getDashManifestUrl();
        this.hlsManifestUrl = rawStreamingData.getHlsManifestUrl();
        this.probeUrl = rawStreamingData.getProbeUrl();
        this.muxedStreams = rawStreamingData.getMuxedStreams();
        List<AdaptiveStream> adaptiveStreams = rawStreamingData.getAdaptiveStreams();
        if (adaptiveStreams != null && adaptiveStreams.size() > 0) {
            sortAdaptiveStreamsByType(adaptiveStreams);
        }
    }

    public StreamingData(String expiresInSeconds, String dashManifestUrl, String hlsManifestUrl, List<AdaptiveAudioStream> adaptiveAudioStreams, List<AdaptiveVideoStream> adaptiveVideoStreams) {
        this.expiresInSeconds = expiresInSeconds;
        this.dashManifestUrl = dashManifestUrl;
        this.hlsManifestUrl = hlsManifestUrl;
        this.adaptiveAudioStreams = adaptiveAudioStreams;
        this.adaptiveVideoStreams = adaptiveVideoStreams;
    }

    protected StreamingData(Parcel in) {
        expiresInSeconds = in.readString();
        dashManifestUrl = in.readString();
        hlsManifestUrl = in.readString();
        adaptiveAudioStreams = in.createTypedArrayList(AdaptiveAudioStream.CREATOR);
        adaptiveVideoStreams = in.createTypedArrayList(AdaptiveVideoStream.CREATOR);
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

    public List<MuxedStream> getMuxedStreams() {
        return muxedStreams;
    }

    public void setMuxedStreams(List<MuxedStream> muxedStreams) {
        this.muxedStreams = muxedStreams;
    }

    public String getProbeUrl() {
        return probeUrl;
    }

    public void setProbeUrl(String probeUrl) {
        this.probeUrl = probeUrl;
    }

    public List<AdaptiveAudioStream> getAdaptiveAudioStreams() {
        return adaptiveAudioStreams;
    }

    public void setAdaptiveAudioStreams(List<AdaptiveAudioStream> adaptiveAudioStreams) {
        this.adaptiveAudioStreams = adaptiveAudioStreams;
    }

    public List<AdaptiveVideoStream> getAdaptiveVideoStreams() {
        return adaptiveVideoStreams;
    }

    public void setAdaptiveVideoStreams(List<AdaptiveVideoStream> adaptiveVideoStreams) {
        this.adaptiveVideoStreams = adaptiveVideoStreams;
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
        dest.writeList(adaptiveAudioStreams);
        dest.writeList(adaptiveVideoStreams);
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
        if (adaptiveAudioStreams != null ? !adaptiveAudioStreams.equals(that.adaptiveAudioStreams) : that.adaptiveAudioStreams != null)
            return false;
        return adaptiveVideoStreams != null ? adaptiveVideoStreams.equals(that.adaptiveVideoStreams) : that.adaptiveVideoStreams == null;
    }

    @Override
    public int hashCode() {
        int result = expiresInSeconds != null ? expiresInSeconds.hashCode() : 0;
        result = 31 * result + (dashManifestUrl != null ? dashManifestUrl.hashCode() : 0);
        result = 31 * result + (hlsManifestUrl != null ? hlsManifestUrl.hashCode() : 0);
        result = 31 * result + (adaptiveAudioStreams != null ? adaptiveAudioStreams.hashCode() : 0);
        result = 31 * result + (adaptiveVideoStreams != null ? adaptiveVideoStreams.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RawStreamingData{" +
                "expiresInSeconds='" + expiresInSeconds + '\'' +
                ", dashManifestUrl='" + dashManifestUrl + '\'' +
                ", hlsManifestUrl='" + hlsManifestUrl + '\'' +
                ", audioStreamItems=" + adaptiveAudioStreams +
                ", videoStreamItems=" + adaptiveVideoStreams +
                '}';
    }

    private void sortAdaptiveStreamsByType(List<AdaptiveStream> adaptiveStreams) {
        List<AdaptiveVideoStream> adaptiveVideoStreams = new ArrayList<>();
        List<AdaptiveAudioStream> adaptiveAudioStreams = new ArrayList<>();

        for (AdaptiveStream adaptiveFormat : adaptiveStreams) {
            String mimeType = adaptiveFormat.getMimeType();
            if (mimeType.contains("audio")) {
                adaptiveAudioStreams.add(new AdaptiveAudioStream(adaptiveFormat));
            } else if (mimeType.contains("video")) {
                adaptiveVideoStreams.add(new AdaptiveVideoStream(adaptiveFormat));
            } else {
                LogE(getClass().getSimpleName(), "Unknown stream type found: " + mimeType);
            }
        }
        this.adaptiveAudioStreams = adaptiveAudioStreams;
        this.adaptiveVideoStreams = adaptiveVideoStreams;
    }
}