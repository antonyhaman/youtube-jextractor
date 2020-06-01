package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

public class FeedbackEndpoint implements Serializable {

    private UiActions uiActions;
    private String feedbackToken;

    public UiActions getUiActions() {
        return uiActions;
    }

    public void setUiActions(UiActions uiActions) {
        this.uiActions = uiActions;
    }

    public String getFeedbackToken() {
        return feedbackToken;
    }

    public void setFeedbackToken(String feedbackToken) {
        this.feedbackToken = feedbackToken;
    }

    @Override
    public String toString() {
        return
                "FeedbackEndpoint{" +
                        "uiActions = '" + uiActions + '\'' +
                        ",feedbackToken = '" + feedbackToken + '\'' +
                        "}";
    }
}
