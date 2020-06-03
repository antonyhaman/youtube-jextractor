package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RawStreamingData implements Serializable {

    @SerializedName("formats")
    private List<MuxedStream> muxedStreams;
    @SerializedName("probeUrl")
    private String probeUrl;
    @SerializedName("adaptiveFormats")
    private List<AdaptiveStream> adaptiveStreams;
    private String expiresInSeconds;
    private String dashManifestUrl;
    private String hlsManifestUrl;

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

    public List<AdaptiveStream> getAdaptiveStreams() {
        return adaptiveStreams;
    }

    public void setAdaptiveStreams(List<AdaptiveStream> adaptiveStreams) {
        this.adaptiveStreams = adaptiveStreams;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RawStreamingData that = (RawStreamingData) o;

        if (muxedStreams != null ? !muxedStreams.equals(that.muxedStreams) : that.muxedStreams != null)
            return false;
        if (probeUrl != null ? !probeUrl.equals(that.probeUrl) : that.probeUrl != null)
            return false;
        if (adaptiveStreams != null ? !adaptiveStreams.equals(that.adaptiveStreams) : that.adaptiveStreams != null)
            return false;
        if (expiresInSeconds != null ? !expiresInSeconds.equals(that.expiresInSeconds) : that.expiresInSeconds != null)
            return false;
        if (dashManifestUrl != null ? !dashManifestUrl.equals(that.dashManifestUrl) : that.dashManifestUrl != null)
            return false;
        return hlsManifestUrl != null ? hlsManifestUrl.equals(that.hlsManifestUrl) : that.hlsManifestUrl == null;
    }

    @Override
    public int hashCode() {
        int result = muxedStreams != null ? muxedStreams.hashCode() : 0;
        result = 31 * result + (probeUrl != null ? probeUrl.hashCode() : 0);
        result = 31 * result + (adaptiveStreams != null ? adaptiveStreams.hashCode() : 0);
        result = 31 * result + (expiresInSeconds != null ? expiresInSeconds.hashCode() : 0);
        result = 31 * result + (dashManifestUrl != null ? dashManifestUrl.hashCode() : 0);
        result = 31 * result + (hlsManifestUrl != null ? hlsManifestUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RawStreamingData{" +
                "formats=" + muxedStreams +
                ", probeUrl='" + probeUrl + '\'' +
                ", adaptiveFormats=" + adaptiveStreams +
                ", expiresInSeconds='" + expiresInSeconds + '\'' +
                ", dashManifestUrl='" + dashManifestUrl + '\'' +
                ", hlsManifestUrl='" + hlsManifestUrl + '\'' +
                '}';
    }
}