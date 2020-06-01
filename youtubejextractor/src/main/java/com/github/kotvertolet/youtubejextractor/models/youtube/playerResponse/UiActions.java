package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class UiActions implements Serializable {
    private boolean hideEnclosingContainer;

    public boolean isHideEnclosingContainer() {
        return hideEnclosingContainer;
    }

    public void setHideEnclosingContainer(boolean hideEnclosingContainer) {
        this.hideEnclosingContainer = hideEnclosingContainer;
    }

    @Override
    public String toString() {
        return
                "UiActions{" +
                        "hideEnclosingContainer = '" + hideEnclosingContainer + '\'' +
                        "}";
    }
}
