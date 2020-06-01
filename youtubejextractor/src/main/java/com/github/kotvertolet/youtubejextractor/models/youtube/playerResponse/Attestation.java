package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class Attestation implements Serializable {

    private PlayerAttestationRenderer playerAttestationRenderer;

    public PlayerAttestationRenderer getPlayerAttestationRenderer() {
        return playerAttestationRenderer;
    }

    public void setPlayerAttestationRenderer(PlayerAttestationRenderer playerAttestationRenderer) {
        this.playerAttestationRenderer = playerAttestationRenderer;
    }

    @Override
    public String toString() {
        return
                "Attestation{" +
                        "playerAttestationRenderer = '" + playerAttestationRenderer + '\'' +
                        "}";
    }
}
