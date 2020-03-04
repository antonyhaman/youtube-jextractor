package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class StreamSelectionConfig {
    private String maxBitrate;

    public String getMaxBitrate() {
        return maxBitrate;
    }

    public void setMaxBitrate(String maxBitrate) {
        this.maxBitrate = maxBitrate;
    }

    @Override
    public String toString() {
        return
                "StreamSelectionConfig{" +
                        "maxBitrate = '" + maxBitrate + '\'' +
                        "}";
    }
}
