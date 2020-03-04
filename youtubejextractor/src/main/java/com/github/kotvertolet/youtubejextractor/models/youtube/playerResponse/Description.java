package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class Description {

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
                "Description{" +
                        "simpleText = '" + simpleText + '\'' +
                        "}";
    }
}
