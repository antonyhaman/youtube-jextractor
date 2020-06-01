package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class PlayerAttestationRenderer implements Serializable {
    private BotguardData botguardData;
    private String challenge;

    public BotguardData getBotguardData() {
        return botguardData;
    }

    public void setBotguardData(BotguardData botguardData) {
        this.botguardData = botguardData;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    @Override
    public String toString() {
        return
                "PlayerAttestationRenderer{" +
                        "botguardData = '" + botguardData + '\'' +
                        ",challenge = '" + challenge + '\'' +
                        "}";
    }
}
