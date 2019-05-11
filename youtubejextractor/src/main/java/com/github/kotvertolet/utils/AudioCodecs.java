package com.github.kotvertolet.utils;

public enum AudioCodecs {

    MP3("mp3"),
    AAC("aac"),
    VORBIS("vorbis"),
    DTSE("dtse"),
    AC3("ac-3"),
    OPUS("opus");

    private final String audioCodec;

    AudioCodecs(final String audioCodec) {
        this.audioCodec = audioCodec;
    }

    @Override
    public String toString() {
        return audioCodec;
    }
}