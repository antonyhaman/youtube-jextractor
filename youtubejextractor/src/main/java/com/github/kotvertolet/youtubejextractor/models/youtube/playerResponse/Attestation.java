package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class Attestation {

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
