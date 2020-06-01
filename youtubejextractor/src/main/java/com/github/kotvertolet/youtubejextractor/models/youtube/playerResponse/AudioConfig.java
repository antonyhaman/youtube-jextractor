package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class AudioConfig implements Serializable {

    private double perceptualLoudnessDb;
    private double loudnessDb;
    private boolean enablePerFormatLoudness;

    public double getPerceptualLoudnessDb() {
        return perceptualLoudnessDb;
    }

    public void setPerceptualLoudnessDb(double perceptualLoudnessDb) {
        this.perceptualLoudnessDb = perceptualLoudnessDb;
    }

    public double getLoudnessDb() {
        return loudnessDb;
    }

    public void setLoudnessDb(double loudnessDb) {
        this.loudnessDb = loudnessDb;
    }

    public boolean isEnablePerFormatLoudness() {
        return enablePerFormatLoudness;
    }

    public void setEnablePerFormatLoudness(boolean enablePerFormatLoudness) {
        this.enablePerFormatLoudness = enablePerFormatLoudness;
    }

    @Override
    public String toString() {
        return
                "AudioConfig{" +
                        "perceptualLoudnessDb = '" + perceptualLoudnessDb + '\'' +
                        ",loudnessDb = '" + loudnessDb + '\'' +
                        ",enablePerFormatLoudness = '" + enablePerFormatLoudness + '\'' +
                        "}";
    }
}
