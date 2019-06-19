package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;

import java.util.Map;

public class VideoStreamItem extends StreamItem {

    public static final Creator<VideoStreamItem> CREATOR = new Creator<VideoStreamItem>() {

        @Override
        public VideoStreamItem createFromParcel(Parcel source) {
            String extension = source.readString();
            String codec = source.readString();
            int bitrate = source.readInt();
            String signature = source.readString();
            String sp = source.readString();
            int itag = source.readInt();
            String url = source.readString();
            boolean isStreamEncrypted = source.readInt() == 1;

            int fps = source.readInt();
            String size = source.readString();
            String qualityLabel = source.readString();
            int projectionType = source.readInt();
            return new VideoStreamItem(extension, codec, bitrate, signature, sp, itag, url, isStreamEncrypted, fps, size, qualityLabel, projectionType);
        }

        @Override
        public VideoStreamItem[] newArray(int size) {
            return new VideoStreamItem[0];
        }
    };
    private int fps;
    private String size;
    private String qualityLabel;
    private int projectionType;

    public VideoStreamItem() {
    }

    public VideoStreamItem(String extension, String codec, int bitrate, String signature, String sp, int iTag, String url, boolean isStreamEncrypted, int fps, String size, String qualityLabel, int projectionType) {
        super(extension, codec, bitrate, signature, sp, iTag, url, isStreamEncrypted);
        this.fps = fps;
        this.size = size;
        this.qualityLabel = qualityLabel;
        this.projectionType = projectionType;
    }

    public VideoStreamItem(Map<String, String> map) {
        super(map);
        String rawFps = map.get("fps") == null ? "0" : map.get("fps");
        fps = Integer.valueOf(rawFps);
        size = map.get("size");
        qualityLabel = map.get("quality_label");
        String rawProjectionType = map.get("projection_type") == null ? "0" : map.get("projection_type");
        projectionType = Integer.valueOf(rawProjectionType);
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

    public int getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(int projectionType) {
        this.projectionType = projectionType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public int getiTag() {
        return iTag;
    }

    public void setiTag(int iTag) {
        this.iTag = iTag;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isStreamEncrypted() {
        return isStreamEncrypted;
    }

    public void setStreamEncrypted(boolean streamEncrypted) {
        isStreamEncrypted = streamEncrypted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoStreamItem)) return false;

        VideoStreamItem that = (VideoStreamItem) o;

        if (fps != that.fps) return false;
        if (projectionType != that.projectionType) return false;
        if (bitrate != that.bitrate) return false;
        if (iTag != that.iTag) return false;
        if (isStreamEncrypted != that.isStreamEncrypted) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (qualityLabel != null ? !qualityLabel.equals(that.qualityLabel) : that.qualityLabel != null)
            return false;
        if (extension != that.extension) return false;
        if (codec != that.codec) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null)
            return false;
        if (sp != null ? !sp.equals(that.sp) : that.sp != null) return false;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        int result = fps;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (qualityLabel != null ? qualityLabel.hashCode() : 0);
        result = 31 * result + projectionType;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (codec != null ? codec.hashCode() : 0);
        result = 31 * result + bitrate;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (sp != null ? sp.hashCode() : 0);
        result = 31 * result + iTag;
        result = 31 * result + url.hashCode();
        result = 31 * result + (isStreamEncrypted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VideoStreamItem{" +
                "fps=" + fps +
                ", size='" + size + '\'' +
                ", qualityLabel='" + qualityLabel + '\'' +
                ", projectionType=" + projectionType +
                ", extension=" + extension +
                ", codec=" + codec +
                ", bitrate=" + bitrate +
                ", signature='" + signature + '\'' +
                ", sp='" + sp + '\'' +
                ", iTag=" + iTag +
                ", url='" + url + '\'' +
                ", isStreamEncrypted=" + isStreamEncrypted +
                '}';
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
        dest.writeString(signature);
        dest.writeString(sp);
        dest.writeInt(iTag);
        dest.writeString(url);
        dest.writeInt(isStreamEncrypted ? 1 : 0);

        dest.writeInt(fps);
        dest.writeString(size);
        dest.writeString(qualityLabel);
        dest.writeInt(projectionType);
    }
}
