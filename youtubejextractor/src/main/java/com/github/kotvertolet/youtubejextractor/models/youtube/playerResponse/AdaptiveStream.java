package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AdaptiveStream implements Serializable {

    private int itag;
    @SerializedName(value = "signatureCipher", alternate = "cipher")
    private Cipher cipher;
    private IndexRange indexRange;
    private String projectionType;
    private InitRange initRange;
    private int bitrate;
    private String mimeType;
    private String audioQuality;
    private String approxDurationMs;
    private String audioSampleRate;
    private String quality;
    private int audioChannels;
    private String contentLength;
    private String lastModified;
    private int averageBitrate;
    private boolean highReplication;
    private int fps;
    private String qualityLabel;
    private int width;
    private int height;
    private ColorInfo colorInfo;
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

    public IndexRange getIndexRange() {
        return indexRange;
    }

    public void setIndexRange(IndexRange indexRange) {
        this.indexRange = indexRange;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    public InitRange getInitRange() {
        return initRange;
    }

    public void setInitRange(InitRange initRange) {
        this.initRange = initRange;
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

    public int getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
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

    public int getAverageBitrate() {
        return averageBitrate;
    }

    public void setAverageBitrate(int averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    public boolean isHighReplication() {
        return highReplication;
    }

    public void setHighReplication(boolean highReplication) {
        this.highReplication = highReplication;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ColorInfo getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
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
                "AdaptiveFormatItem{" +
                        "itag = '" + itag + '\'' +
                        ",cipher = '" + cipher + '\'' +
                        ",indexRange = '" + indexRange + '\'' +
                        ",projectionType = '" + projectionType + '\'' +
                        ",initRange = '" + initRange + '\'' +
                        ",bitrate = '" + bitrate + '\'' +
                        ",mimeType = '" + mimeType + '\'' +
                        ",audioQuality = '" + audioQuality + '\'' +
                        ",approxDurationMs = '" + approxDurationMs + '\'' +
                        ",audioSampleRate = '" + audioSampleRate + '\'' +
                        ",quality = '" + quality + '\'' +
                        ",audioChannels = '" + audioChannels + '\'' +
                        ",contentLength = '" + contentLength + '\'' +
                        ",lastModified = '" + lastModified + '\'' +
                        ",averageBitrate = '" + averageBitrate + '\'' +
                        ",highReplication = '" + highReplication + '\'' +
                        ",fps = '" + fps + '\'' +
                        ",qualityLabel = '" + qualityLabel + '\'' +
                        ",width = '" + width + '\'' +
                        ",height = '" + height + '\'' +
                        ",colorInfo = '" + colorInfo + '\'' +
                        "}";
    }
}
