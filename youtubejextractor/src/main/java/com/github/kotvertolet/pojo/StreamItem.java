package com.github.kotvertolet.pojo;

import java.util.Map;

public class StreamItem {

    private String type;
    private String extension;
    private String codec;
    private int bitrate;
    private String signature;
    private String sp;
    private int iTag;
    private String url;
    private boolean isStreamEncrypted;

    // Only for video streams
    private int fps;
    private String size;
    private String qualityLabel;
    private int projectionType;

    // Only for audio streams
    private int audioChannels;
    private int audioSampleRate;

    public StreamItem(Map<String, String> map) {
        String[] tempArr = map.get("type").split(";");
        String[] typeArr = tempArr[0].split("/");
        type = typeArr[0];
        extension = typeArr[1];
        codec = tempArr[1].split("=")[1].replaceAll("\"", "");
        if (type.contains("video")) {
            fps = Integer.valueOf(map.get("fps"));
            size = map.get("size");
            qualityLabel = map.get("quality_label");
            projectionType = Integer.valueOf(map.get("projection_type"));
        } else {
            audioChannels = Integer.valueOf(map.get("audio_channels"));
            audioSampleRate = Integer.valueOf(map.get("audio_sample_rate"));
        }
        signature = map.get("s");
        sp = map.get("sp");
        isStreamEncrypted = signature != null;
        iTag = Integer.valueOf(map.get("itag"));
        url = map.get("url");
        bitrate = Integer.valueOf(map.get("bitrate"));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUrl() {
        if (isStreamEncrypted) {
            isStreamEncrypted = false;
            url = String.format("%s&%s=%s", url, sp, signature);
            if (!url.contains("ratebypass")) {
                url = url + "&ratebypass=yes";
            }
            isStreamEncrypted = false;
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public boolean isStreamEncrypted() {
        return isStreamEncrypted;
    }

    public void setStreamEncrypted(boolean streamEncrypted) {
        isStreamEncrypted = streamEncrypted;
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

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    public int getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(int audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamItem)) return false;

        StreamItem that = (StreamItem) o;

        if (bitrate != that.bitrate) return false;
        if (iTag != that.iTag) return false;
        if (isStreamEncrypted != that.isStreamEncrypted) return false;
        if (fps != that.fps) return false;
        if (projectionType != that.projectionType) return false;
        if (audioChannels != that.audioChannels) return false;
        if (audioSampleRate != that.audioSampleRate) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null)
            return false;
        if (codec != null ? !codec.equals(that.codec) : that.codec != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        return qualityLabel != null ? qualityLabel.equals(that.qualityLabel) : that.qualityLabel == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (codec != null ? codec.hashCode() : 0);
        result = 31 * result + bitrate;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + iTag;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (isStreamEncrypted ? 1 : 0);
        result = 31 * result + fps;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (qualityLabel != null ? qualityLabel.hashCode() : 0);
        result = 31 * result + projectionType;
        result = 31 * result + audioChannels;
        result = 31 * result + audioSampleRate;
        return result;
    }

    @Override
    public String toString() {
        return "StreamItem{" +
                "type='" + type + '\'' +
                ", extension='" + extension + '\'' +
                ", codec='" + codec + '\'' +
                ", bitrate=" + bitrate +
                ", signature='" + signature + '\'' +
                ", iTag=" + iTag +
                ", url='" + url + '\'' +
                ", isStreamEncrypted=" + isStreamEncrypted +
                ", fps=" + fps +
                ", size='" + size + '\'' +
                ", qualityLabel='" + qualityLabel + '\'' +
                ", projectionType=" + projectionType +
                ", audioChannels=" + audioChannels +
                ", audioSampleRate=" + audioSampleRate +
                '}';
    }
}
