package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class PlayerStoryboardSpecRenderer {
    private String spec;

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return
                "PlayerStoryboardSpecRenderer{" +
                        "spec = '" + spec + '\'' +
                        "}";
    }
}
