package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class ActionButton {
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
                "ActionButton{" +
                        "buttonRenderer = '" + buttonRenderer + '\'' +
                        "}";
    }
}
