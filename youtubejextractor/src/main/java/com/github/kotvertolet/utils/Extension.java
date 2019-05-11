package com.github.kotvertolet.utils;

public enum Extension {

    FLV("flv"),
    _3GPP("3gpp"),
    MP4("mp4"),
    WEBM("webm"),
    M4A("m4a");

    private final String extension;

    Extension(final String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return extension;
    }
}
