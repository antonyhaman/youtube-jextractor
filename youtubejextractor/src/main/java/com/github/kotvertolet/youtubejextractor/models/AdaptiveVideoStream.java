package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.AdaptiveStream;

public class AdaptiveVideoStream extends StreamItem {

    public static final Creator<AdaptiveVideoStream> CREATOR = new Creator<AdaptiveVideoStream>() {

        @Override
        public AdaptiveVideoStream createFromParcel(Parcel source) {
            String extension = source.readString();
            String codec = source.readString();
            int bitrate = source.readInt();
            int iTag = source.readInt();
            String url = source.readString();
            int averageBitrate = source.readInt();
            int approxDurationMs = source.readInt();
            int fps = source.readInt();
            String size = source.readString();
            String qualityLabel = source.readString();
            String projectionType = source.readString();
            return new AdaptiveVideoStream(extension, codec, bitrate, iTag, url, averageBitrate, approxDurationMs, fps, size, qualityLabel, projectionType);
        }

        @Override
        public AdaptiveVideoStream[] newArray(int size) {
            return new AdaptiveVideoStream[0];
        }
    };
    private int fps;
    private String size;
    private String qualityLabel;
    private String projectionType;


    public AdaptiveVideoStream(String extension, String codec, int bitrate, int iTag, String url, int averageBitrate, int approxDurationMs, int fps, String size, String qualityLabel, String projectionType) {
        super(extension, codec, bitrate, iTag, url, averageBitrate, approxDurationMs);
        this.fps = fps;
        this.size = size;
        this.qualityLabel = qualityLabel;
        this.projectionType = projectionType;
    }

    public AdaptiveVideoStream(AdaptiveStream adaptiveFormat) {
        super(adaptiveFormat);
        fps = adaptiveFormat.getFps();
        qualityLabel = adaptiveFormat.getQualityLabel();
        projectionType = adaptiveFormat.getProjectionType();
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(extension);
        dest.writeString(codec);
        dest.writeInt(bitrate);
        dest.writeInt(iTag);
        dest.writeString(url);
        dest.writeInt(averageBitrate);
        dest.writeInt(approxDurationMs);
        dest.writeInt(fps);
        dest.writeString(size);
        dest.writeString(qualityLabel);
        dest.writeString(projectionType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AdaptiveVideoStream that = (AdaptiveVideoStream) o;

        if (fps != that.fps) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (qualityLabel != null ? !qualityLabel.equals(that.qualityLabel) : that.qualityLabel != null)
            return false;
        return projectionType != null ? projectionType.equals(that.projectionType) : that.projectionType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fps;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (qualityLabel != null ? qualityLabel.hashCode() : 0);
        result = 31 * result + (projectionType != null ? projectionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VideoStreamItem{" +
                "fps=" + fps +
                ", size='" + size + '\'' +
                ", qualityLabel='" + qualityLabel + '\'' +
                ", projectionType=" + projectionType +
                ", extension='" + extension + '\'' +
                ", codec='" + codec + '\'' +
                ", bitrate=" + bitrate +
                ", iTag=" + iTag +
                ", url='" + url + '\'' +
                ", averageBitrate=" + averageBitrate +
                ", approxDurationMs=" + approxDurationMs +
                '}';
    }
}
