package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class DynamicReadaheadConfig implements Serializable {

    private int readAheadGrowthRateMs;
    private int maxReadAheadMediaTimeMs;
    private int minReadAheadMediaTimeMs;

    public int getReadAheadGrowthRateMs() {
        return readAheadGrowthRateMs;
    }

    public void setReadAheadGrowthRateMs(int readAheadGrowthRateMs) {
        this.readAheadGrowthRateMs = readAheadGrowthRateMs;
    }

    public int getMaxReadAheadMediaTimeMs() {
        return maxReadAheadMediaTimeMs;
    }

    public void setMaxReadAheadMediaTimeMs(int maxReadAheadMediaTimeMs) {
        this.maxReadAheadMediaTimeMs = maxReadAheadMediaTimeMs;
    }

    public int getMinReadAheadMediaTimeMs() {
        return minReadAheadMediaTimeMs;
    }

    public void setMinReadAheadMediaTimeMs(int minReadAheadMediaTimeMs) {
        this.minReadAheadMediaTimeMs = minReadAheadMediaTimeMs;
    }

    @Override
    public String toString() {
        return
                "DynamicReadaheadConfig{" +
                        "readAheadGrowthRateMs = '" + readAheadGrowthRateMs + '\'' +
                        ",maxReadAheadMediaTimeMs = '" + maxReadAheadMediaTimeMs + '\'' +
                        ",minReadAheadMediaTimeMs = '" + minReadAheadMediaTimeMs + '\'' +
                        "}";
    }
}
