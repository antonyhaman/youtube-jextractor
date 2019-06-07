package com.github.kotvertolet.youtubejextractor.pojo;

import com.github.kotvertolet.youtubejextractor.pojo.enums.Codec;
import com.github.kotvertolet.youtubejextractor.pojo.enums.Extension;
import com.github.kotvertolet.youtubejextractor.pojo.enums.StreamType;

import java.util.Map;

public class StreamItem {

    private StreamType streamType;
    private Extension extension;
    private Codec codec;
    private int bitrate;
    private String signature;
    private String sp;
    private int iTag;
    private String url;
    private boolean isStreamEncrypted;

    // Only for video streams
    private int fps;
    private String size;
    private String qualityLabel;
    private int projectionType;

    // Only for audio streams
    private int audioChannels;
    private int audioSampleRate;

    public StreamItem(Map<String, String> map) {
        String[] tempArr = map.get("type").split(";");
        String[] typeArr = tempArr[0].split("/");

        streamType = typeArr[0].equals(StreamType.VIDEO.toString()) ? StreamType.VIDEO : StreamType.AUDIO;
        extension = extractExtension(typeArr[1]);
        codec = extractCodec(tempArr[1]);
        if (streamType.equals(StreamType.VIDEO)) {
            fps = Integer.valueOf(map.get("fps"));
            size = map.get("size");
            qualityLabel = map.get("quality_label");
            projectionType = Integer.valueOf(map.get("projection_type"));
        } else {
            audioChannels = Integer.valueOf(map.get("audio_channels"));
            audioSampleRate = Integer.valueOf(map.get("audio_sample_rate"));
        }
        signature = map.get("s");
        sp = map.get("sp");
        isStreamEncrypted = signature != null;
        iTag = Integer.valueOf(map.get("itag"));
        url = map.get("url");
        bitrate = Integer.valueOf(map.get("bitrate"));
    }

    public StreamType getStreamType() {
        return streamType;
    }

    public void setStreamType(StreamType streamType) {
        this.streamType = streamType;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public Codec getCodec() {
        return codec;
    }

    public void setCodec(Codec codec) {
        this.codec = codec;
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

    public String getUrl() {
        if (isStreamEncrypted) {
            isStreamEncrypted = false;
            url = String.format("%s&%s=%s", url, sp, signature);
            if (!url.contains("ratebypass")) {
                url = url + "&ratebypass=yes";
            }
            isStreamEncrypted = false;
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public boolean isStreamEncrypted() {
        return isStreamEncrypted;
    }

    public void setStreamEncrypted(boolean streamEncrypted) {
        isStreamEncrypted = streamEncrypted;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public int getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(int projectionType) {
        this.projectionType = projectionType;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamItem)) return false;

        StreamItem that = (StreamItem) o;

        if (bitrate != that.bitrate) return false;
        if (iTag != that.iTag) return false;
        if (isStreamEncrypted != that.isStreamEncrypted) return false;
        if (fps != that.fps) return false;
        if (projectionType != that.projectionType) return false;
        if (audioChannels != that.audioChannels) return false;
        if (audioSampleRate != that.audioSampleRate) return false;
        if (streamType != that.streamType) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null)
            return false;
        if (codec != null ? !codec.equals(that.codec) : that.codec != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null)
            return false;
        if (sp != null ? !sp.equals(that.sp) : that.sp != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        return qualityLabel != null ? qualityLabel.equals(that.qualityLabel) : that.qualityLabel == null;
    }

    @Override
    public int hashCode() {
        int result = streamType != null ? streamType.hashCode() : 0;
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (codec != null ? codec.hashCode() : 0);
        result = 31 * result + bitrate;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (sp != null ? sp.hashCode() : 0);
        result = 31 * result + iTag;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (isStreamEncrypted ? 1 : 0);
        result = 31 * result + fps;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (qualityLabel != null ? qualityLabel.hashCode() : 0);
        result = 31 * result + projectionType;
        result = 31 * result + audioChannels;
        result = 31 * result + audioSampleRate;
        return result;
    }

    @Override
    public String toString() {
        return "StreamItem{" +
                "streamType=" + streamType +
                ", extension='" + extension + '\'' +
                ", codec='" + codec + '\'' +
                ", bitrate=" + bitrate +
                ", signature='" + signature + '\'' +
                ", sp='" + sp + '\'' +
                ", iTag=" + iTag +
                ", url='" + url + '\'' +
                ", isStreamEncrypted=" + isStreamEncrypted +
                ", fps=" + fps +
                ", size='" + size + '\'' +
                ", qualityLabel='" + qualityLabel + '\'' +
                ", projectionType=" + projectionType +
                ", audioChannels=" + audioChannels +
                ", audioSampleRate=" + audioSampleRate +
                '}';
    }

    private Codec extractCodec(String rawCodec) {
        rawCodec = rawCodec.split("=")[1].replaceAll("\"", "");
        if (rawCodec.contains(".")) {
            rawCodec = rawCodec.split("\\.")[0];
        }

        if (Codec.H263.toString().contains(rawCodec)) {
            return Codec.H263;
        }
        else if (Codec.H264.toString().contains(rawCodec)) {
            return Codec.H264;
        }
        else if (rawCodec.contains(Codec.VP8.toString())) {
            return Codec.VP8;
        }
        else if (rawCodec.contains(Codec.VP9.toString())) {
            return Codec.VP9;
        }
        else if (rawCodec.contains(Codec.AV1.toString())) {
            return Codec.AV1;
        }
        else if (rawCodec.contains(Codec.MP3.toString())) {
            return Codec.MP3;
        }
        else if (rawCodec.contains(Codec.MP4A.toString())) {
            return Codec.MP4A;
        }
        else if (rawCodec.contains(Codec.AAC.toString())) {
            return Codec.AAC;
        }
        else if (rawCodec.contains(Codec.VORBIS.toString())) {
            return Codec.VORBIS;
        }
        else if (rawCodec.contains(Codec.DTSE.toString())) {
            return Codec.DTSE;
        }
        else if (rawCodec.contains(Codec.AC3.toString())) {
            return Codec.AC3;
        }
        else if (rawCodec.contains(Codec.OPUS.toString())) {
            return Codec.OPUS;
        }
        else throw new IllegalArgumentException("Unknown codec found: " + rawCodec);
    }

    private Extension extractExtension(String rawExtension) {
        if (rawExtension.equals(Extension.WEBM.toString())) {
            return Extension.WEBM;
        }
        else if (rawExtension.equals(Extension.GPP.toString())) {
            return Extension.GPP;
        }
        else if (rawExtension.equals(Extension.FLV.toString())) {
            return Extension.FLV;
        }
        else if (rawExtension.equals(Extension.M4A.toString())) {
            return Extension.M4A;
        }
        else if (rawExtension.equals(Extension.MP4.toString())) {
            return Extension.MP4;
        }
        else {
            throw new IllegalArgumentException("Unknown extension found: " + rawExtension);
        }
    }
}
