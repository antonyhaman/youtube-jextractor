package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.util.List;

public class RawStreamingData {

    private List<FormatsItem> formats;
    private String probeUrl;
    private List<AdaptiveFormatItem> adaptiveFormats;
    private String expiresInSeconds;
    private String dashManifestUrl;
    private String hlsManifestUrl;

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

    public List<AdaptiveFormatItem> getAdaptiveFormats() {
        return adaptiveFormats;
    }

    public void setAdaptiveFormats(List<AdaptiveFormatItem> adaptiveFormats) {
        this.adaptiveFormats = adaptiveFormats;
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

        if (formats != null ? !formats.equals(that.formats) : that.formats != null) return false;
        if (probeUrl != null ? !probeUrl.equals(that.probeUrl) : that.probeUrl != null)
            return false;
        if (adaptiveFormats != null ? !adaptiveFormats.equals(that.adaptiveFormats) : that.adaptiveFormats != null)
            return false;
        if (expiresInSeconds != null ? !expiresInSeconds.equals(that.expiresInSeconds) : that.expiresInSeconds != null)
            return false;
        if (dashManifestUrl != null ? !dashManifestUrl.equals(that.dashManifestUrl) : that.dashManifestUrl != null)
            return false;
        return hlsManifestUrl != null ? hlsManifestUrl.equals(that.hlsManifestUrl) : that.hlsManifestUrl == null;
    }

    @Override
    public int hashCode() {
        int result = formats != null ? formats.hashCode() : 0;
        result = 31 * result + (probeUrl != null ? probeUrl.hashCode() : 0);
        result = 31 * result + (adaptiveFormats != null ? adaptiveFormats.hashCode() : 0);
        result = 31 * result + (expiresInSeconds != null ? expiresInSeconds.hashCode() : 0);
        result = 31 * result + (dashManifestUrl != null ? dashManifestUrl.hashCode() : 0);
        result = 31 * result + (hlsManifestUrl != null ? hlsManifestUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RawStreamingData{" +
                "formats=" + formats +
                ", probeUrl='" + probeUrl + '\'' +
                ", adaptiveFormats=" + adaptiveFormats +
                ", expiresInSeconds='" + expiresInSeconds + '\'' +
                ", dashManifestUrl='" + dashManifestUrl + '\'' +
                ", hlsManifestUrl='" + hlsManifestUrl + '\'' +
                '}';
    }
}