package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class Description implements Serializable {

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
