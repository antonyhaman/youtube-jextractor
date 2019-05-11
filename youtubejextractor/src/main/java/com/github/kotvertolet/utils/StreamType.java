package com.github.kotvertolet.utils;

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
