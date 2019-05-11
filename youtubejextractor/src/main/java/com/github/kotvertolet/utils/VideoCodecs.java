package com.github.kotvertolet.utils;

public enum VideoCodecs {

    H263("h263"),
    H264("h264"),
    VP8("vp8"),
    VP9("vp9");

    private final String videoCodec;

    VideoCodecs(final String videoCodec) {
        this.videoCodec = videoCodec;
    }

    @Override
    public String toString() {
        return videoCodec;
    }
}