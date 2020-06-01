package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MuxedStream implements Serializable {

    @SerializedName("itag")
    private int itag;
    @SerializedName("signatureCipher")
    private Cipher cipher;
    @SerializedName("projectionType")
    private String projectionType;
    @SerializedName("bitrate")
    private int bitrate;
    @SerializedName("mimeType")
    private String mimeType;
    @SerializedName("audioQuality")
    private String audioQuality;
    @SerializedName("approxDurationMs")
    private String approxDurationMs;
    @SerializedName("audioSampleRate")
    private String audioSampleRate;
    @SerializedName("quality")
    private String quality;
    @SerializedName("qualityLabel")
    private String qualityLabel;
    @SerializedName("audioChannels")
    private int audioChannels;
    @SerializedName("width")
    private int width;
    @SerializedName("contentLength")
    private String contentLength;
    @SerializedName("lastModified")
    private String lastModified;
    @SerializedName("height")
    private int height;
    @SerializedName("averageBitrate")
    private int averageBitrate;
    @SerializedName("url")
    private String url;

    public int getItag() {
        return itag;
    }

    public void setItag(int itag) {
        this.itag = itag;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    public void setApproxDurationMs(String approxDurationMs) {
        this.approxDurationMs = approxDurationMs;
    }

    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAverageBitrate() {
        return averageBitrate;
    }

    public void setAverageBitrate(int averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    public String getUrl() {
        if (url == null && getCipher() != null) {
            url = String.format("%s&%s=%s", getCipher().getUrl(), getCipher().getSp(), getCipher().getS());
        }
        return url;
    }

    @Override
    public String toString() {
        return
                "NonAdaptiveFormatItem{" +
                        "itag = '" + itag + '\'' +
                        ",cipher = '" + cipher + '\'' +
                        ",projectionType = '" + projectionType + '\'' +
                        ",bitrate = '" + bitrate + '\'' +
                        ",mimeType = '" + mimeType + '\'' +
                        ",audioQuality = '" + audioQuality + '\'' +
                        ",approxDurationMs = '" + approxDurationMs + '\'' +
                        ",audioSampleRate = '" + audioSampleRate + '\'' +
                        ",quality = '" + quality + '\'' +
                        ",qualityLabel = '" + qualityLabel + '\'' +
                        ",audioChannels = '" + audioChannels + '\'' +
                        ",width = '" + width + '\'' +
                        ",contentLength = '" + contentLength + '\'' +
                        ",lastModified = '" + lastModified + '\'' +
                        ",height = '" + height + '\'' +
                        ",averageBitrate = '" + averageBitrate + '\'' +
                        "}";
    }
}