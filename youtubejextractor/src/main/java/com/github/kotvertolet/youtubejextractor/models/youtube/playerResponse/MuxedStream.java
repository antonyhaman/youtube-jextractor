package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream;
import com.google.gson.annotations.SerializedName;

public class MuxedStream {

    @SerializedName("itag")
    private int itag;
    @SerializedName("cipher")
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

    public void setItag(int itag) {
        this.itag = itag;
    }

    public int getItag() {
        return itag;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    public String getAudioQuality() {
        return audioQuality;
    }

    public void setApproxDurationMs(String approxDurationMs) {
        this.approxDurationMs = approxDurationMs;
    }

    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setAverageBitrate(int averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    public int getAverageBitrate() {
        return averageBitrate;
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