package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class PlayerConfig implements Serializable {
    private MediaCommonConfig mediaCommonConfig;
    private AudioConfig audioConfig;
    private StreamSelectionConfig streamSelectionConfig;

    public MediaCommonConfig getMediaCommonConfig() {
        return mediaCommonConfig;
    }

    public void setMediaCommonConfig(MediaCommonConfig mediaCommonConfig) {
        this.mediaCommonConfig = mediaCommonConfig;
    }

    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public StreamSelectionConfig getStreamSelectionConfig() {
        return streamSelectionConfig;
    }

    public void setStreamSelectionConfig(StreamSelectionConfig streamSelectionConfig) {
        this.streamSelectionConfig = streamSelectionConfig;
    }

    @Override
    public String toString() {
        return
                "PlayerConfig{" +
                        "mediaCommonConfig = '" + mediaCommonConfig + '\'' +
                        ",audioConfig = '" + audioConfig + '\'' +
                        ",streamSelectionConfig = '" + streamSelectionConfig + '\'' +
                        "}";
    }
}
