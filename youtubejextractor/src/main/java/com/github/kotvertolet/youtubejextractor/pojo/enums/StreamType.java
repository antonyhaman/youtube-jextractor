package com.github.kotvertolet.youtubejextractor.pojo.enums;

public enum StreamType {

    VIDEO("video"),
    AUDIO("audio");

    private final String streamType;

    StreamType(final String streamType) {
        this.streamType = streamType;
    }

    @Override
    public String toString() {
        return streamType;
    }
}
