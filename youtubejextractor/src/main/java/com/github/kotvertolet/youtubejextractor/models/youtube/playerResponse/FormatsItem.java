package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class FormatsItem {

    private int itag;
    private Cipher cipher;
    private String projectionType;
    private int bitrate;
    private String mimeType;
    private String audioQuality;
    private String approxDurationMs;
    private String audioSampleRate;
    private String quality;
    private String qualityLabel;
    private int audioChannels;
    private int width;
    private String contentLength;
    private String lastModified;
    private int height;
    private int averageBitrate;

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

    @Override
    public String toString() {
        return
                "FormatsItem{" +
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
