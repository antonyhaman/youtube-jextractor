package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class PlayerStoryboardSpecRenderer implements Serializable {
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
