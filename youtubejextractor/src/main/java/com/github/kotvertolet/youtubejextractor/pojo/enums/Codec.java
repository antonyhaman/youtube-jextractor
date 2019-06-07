package com.github.kotvertolet.youtubejextractor.pojo.enums;

public enum Codec {

    //Video codecs
    H263("h263"),
    H264("h264/avc1"),
    VP8("vp8"),
    VP9("vp9"),
    AV1("av01"),
    //Audio codecs
    MP3("mp3"),
    MP4A("mp4a"),
    AAC("aac"),
    VORBIS("vorbis"),
    DTSE("dtse"),
    AC3("ac-3"),
    OPUS("opus");

    private final String codec;

    Codec(final String codec) {
        this.codec = codec;
    }

    @Override
    public String toString() {
        return codec;
    }
}
