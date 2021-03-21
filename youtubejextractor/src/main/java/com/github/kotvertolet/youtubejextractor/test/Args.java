package com.github.kotvertolet.youtubejextractor.test;

import com.google.gson.annotations.SerializedName;

public class Args {

    @SerializedName("player_response")
    private String playerResponse;

    public String getPlayerResponse() {
        return playerResponse;
    }

    public void setPlayerResponse(String playerResponse) {
        this.playerResponse = playerResponse;
    }

    @Override
    public String toString() {
        return
                "Args{" +
                        "player_response = '" + playerResponse + '\'' +
                        "}";
    }
}