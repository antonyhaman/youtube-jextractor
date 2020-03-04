package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class Storyboards {
    private PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer;

    public PlayerStoryboardSpecRenderer getPlayerStoryboardSpecRenderer() {
        return playerStoryboardSpecRenderer;
    }

    public void setPlayerStoryboardSpecRenderer(PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer) {
        this.playerStoryboardSpecRenderer = playerStoryboardSpecRenderer;
    }

    @Override
    public String toString() {
        return
                "Storyboards{" +
                        "playerStoryboardSpecRenderer = '" + playerStoryboardSpecRenderer + '\'' +
                        "}";
    }
}
