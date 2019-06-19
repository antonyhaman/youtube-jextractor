package com.github.kotvertolet.youtubejextractor.models.enums;

public enum Extension {

    FLV("flv"),
    GPP("3gpp"),
    MP4("mp4"),
    WEBM("webm"),
    M4A("m4a"),
    UNKNOWN("unknown");

    private final String extension;

    Extension(final String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return extension;
    }
}
