package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class DismissButton {

    private ButtonRenderer buttonRenderer;

    public ButtonRenderer getButtonRenderer() {
        return buttonRenderer;
    }

    public void setButtonRenderer(ButtonRenderer buttonRenderer) {
        this.buttonRenderer = buttonRenderer;
    }

    @Override
    public String toString() {
        return
                "DismissButton{" +
                        "buttonRenderer = '" + buttonRenderer + '\'' +
                        "}";
    }
}
