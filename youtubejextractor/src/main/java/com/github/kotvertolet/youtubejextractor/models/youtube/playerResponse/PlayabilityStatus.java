package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class PlayabilityStatus implements Serializable {
    private boolean playableInEmbed;
    private String contextParams;
    private String status;

    public boolean isPlayableInEmbed() {
        return playableInEmbed;
    }

    public void setPlayableInEmbed(boolean playableInEmbed) {
        this.playableInEmbed = playableInEmbed;
    }

    public String getContextParams() {
        return contextParams;
    }

    public void setContextParams(String contextParams) {
        this.contextParams = contextParams;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "PlayabilityStatus{" +
                        "playableInEmbed = '" + playableInEmbed + '\'' +
                        ",contextParams = '" + contextParams + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
