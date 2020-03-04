package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class Title {
    private String simpleText;

    public String getSimpleText() {
        return simpleText;
    }

    public void setSimpleText(String simpleText) {
        this.simpleText = simpleText;
    }

    @Override
    public String toString() {
        return
                "Title{" +
                        "simpleText = '" + simpleText + '\'' +
                        "}";
    }
}
