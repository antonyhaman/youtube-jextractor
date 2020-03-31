package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.AdaptiveStream;

public class AdaptiveAudioStream extends StreamItem {

    public static final Creator<AdaptiveAudioStream> CREATOR = new Creator<AdaptiveAudioStream>() {

        @Override
        public AdaptiveAudioStream createFromParcel(Parcel source) {
            String extension = source.readString();
            String codec = source.readString();
            int bitrate = source.readInt();
            int iTag = source.readInt();
            String url = source.readString();
            int audioChannels = source.readInt();
            int audioSampleRate = source.readInt();
            int averageBitrate = source.readInt();
            int approxDurationMs = source.readInt();
            return new AdaptiveAudioStream(extension, codec, bitrate, iTag, url, audioChannels,
                    audioSampleRate, averageBitrate, approxDurationMs);
        }

        @Override
        public AdaptiveAudioStream[] newArray(int size) {
            return new AdaptiveAudioStream[size];
        }
    };
    private int audioChannels;
    private int audioSampleRate;

    public AdaptiveAudioStream(String extension, String codec, int bitrate, int iTag, String url,
                               int audioChannels, int audioSampleRate, int averageBitrate, int approxDurationMs) {
        super(extension, codec, bitrate, iTag, url, averageBitrate, approxDurationMs);
        this.audioChannels = audioChannels;
        this.audioSampleRate = audioSampleRate;
    }

    public AdaptiveAudioStream(AdaptiveStream adaptiveStream) {
        super(adaptiveStream);
        audioChannels = adaptiveStream.getAudioChannels();
        audioSampleRate = Integer.valueOf(adaptiveStream.getAudioSampleRate());
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
        dest.writeInt(audioChannels);
        dest.writeInt(audioSampleRate);
        dest.writeInt(averageBitrate);
        dest.writeInt(approxDurationMs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AdaptiveAudioStream that = (AdaptiveAudioStream) o;

        if (audioChannels != that.audioChannels) return false;
        return audioSampleRate == that.audioSampleRate;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + audioChannels;
        result = 31 * result + audioSampleRate;
        return result;
    }
}