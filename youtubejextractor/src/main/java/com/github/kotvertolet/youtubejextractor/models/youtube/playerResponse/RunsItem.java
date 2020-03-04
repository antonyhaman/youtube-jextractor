package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class RunsItem {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return
                "RunsItem{" +
                        "text = '" + text + '\'' +
                        "}";
    }
}
