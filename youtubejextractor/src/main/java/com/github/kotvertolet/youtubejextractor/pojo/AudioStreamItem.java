package com.github.kotvertolet.youtubejextractor.pojo;

import com.github.kotvertolet.youtubejextractor.pojo.enums.Extension;

import java.util.Map;

public class AudioStreamItem extends StreamItem {

    private int audioChannels;
    private int audioSampleRate;

    public AudioStreamItem(Map<String, String> map) {
        super(map);
        String rawAudioChannels = map.get("audio_channels") == null ? "0" : map.get("audio_channels");
        audioChannels = Integer.valueOf(rawAudioChannels);
        String rawAudioSampleRate = map.get("audio_sample_rate") == null ? "0" : map.get("audio_sample_rate");
        audioSampleRate = Integer.valueOf(rawAudioSampleRate);
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
        if (!(o instanceof AudioStreamItem)) return false;

        AudioStreamItem that = (AudioStreamItem) o;

        if (audioChannels != that.audioChannels) return false;
        if (audioSampleRate != that.audioSampleRate) return false;
        if (bitrate != that.bitrate) return false;
        if (iTag != that.iTag) return false;
        if (isStreamEncrypted != that.isStreamEncrypted) return false;
        if (extension != that.extension) return false;
        if (codec != that.codec) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null)
            return false;
        if (sp != null ? !sp.equals(that.sp) : that.sp != null) return false;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        int result = audioChannels;
        result = 31 * result + audioSampleRate;
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
        return "AudioStreamItem{" +
                "audioChannels=" + audioChannels +
                ", audioSampleRate=" + audioSampleRate +
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
