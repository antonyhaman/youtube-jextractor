package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;

import java.util.Map;

public class AudioStreamItem extends StreamItem {

    public static final Creator<AudioStreamItem> CREATOR = new Creator<AudioStreamItem>() {

        @Override
        public AudioStreamItem createFromParcel(Parcel source) {
            String extension = source.readString();
            String codec = source.readString();
            int bitrate = source.readInt();
            String signature = source.readString();
            String sp = source.readString();
            int itag = source.readInt();
            String url = source.readString();
            boolean isStreamEncrypted = source.readInt() == 1;

            int audioChannels = source.readInt();
            int audioSampleRate = source.readInt();
            return new AudioStreamItem(extension, codec, bitrate, signature, sp, itag, url, isStreamEncrypted, audioChannels, audioSampleRate);
        }

        @Override
        public AudioStreamItem[] newArray(int size) {
            return new AudioStreamItem[size];
        }
    };
    private int audioChannels;
    private int audioSampleRate;

    public AudioStreamItem() {
    }

    public AudioStreamItem(String extension, String codec, int bitrate, String signature, String sp,
                           int iTag, String url, boolean isStreamEncrypted, int audioChannels, int audioSampleRate) {
        super(extension, codec, bitrate, signature, sp, iTag, url, isStreamEncrypted);
        this.audioChannels = audioChannels;
        this.audioSampleRate = audioSampleRate;
    }

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

        dest.writeInt(audioChannels);
        dest.writeInt(audioSampleRate);
    }
}
