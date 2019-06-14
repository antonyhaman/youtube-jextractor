package com.github.kotvertolet.youtubejextractor.pojo;

import com.github.kotvertolet.youtubejextractor.pojo.enums.Extension;

import java.util.Map;

public class VideoStreamItem extends StreamItem {

    private int fps;
    private String size;
    private String qualityLabel;
    private int projectionType;

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

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
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
}
