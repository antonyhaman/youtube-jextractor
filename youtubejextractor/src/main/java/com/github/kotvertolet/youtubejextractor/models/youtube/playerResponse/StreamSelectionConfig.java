package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class StreamSelectionConfig implements Serializable {
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
