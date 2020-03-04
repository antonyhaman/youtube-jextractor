package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class Microformat {

    private PlayerMicroformatRenderer playerMicroformatRenderer;

    public PlayerMicroformatRenderer getPlayerMicroformatRenderer() {
        return playerMicroformatRenderer;
    }

    public void setPlayerMicroformatRenderer(PlayerMicroformatRenderer playerMicroformatRenderer) {
        this.playerMicroformatRenderer = playerMicroformatRenderer;
    }

    @Override
    public String toString() {
        return
                "Microformat{" +
                        "playerMicroformatRenderer = '" + playerMicroformatRenderer + '\'' +
                        "}";
    }
}
