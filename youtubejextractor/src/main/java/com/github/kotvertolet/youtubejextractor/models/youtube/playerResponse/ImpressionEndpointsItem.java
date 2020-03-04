package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

public class ImpressionEndpointsItem {

    private FeedbackEndpoint feedbackEndpoint;
    private String clickTrackingParams;

    public FeedbackEndpoint getFeedbackEndpoint() {
        return feedbackEndpoint;
    }

    public void setFeedbackEndpoint(FeedbackEndpoint feedbackEndpoint) {
        this.feedbackEndpoint = feedbackEndpoint;
    }

    public String getClickTrackingParams() {
        return clickTrackingParams;
    }

    public void setClickTrackingParams(String clickTrackingParams) {
        this.clickTrackingParams = clickTrackingParams;
    }

    @Override
    public String toString() {
        return
                "ImpressionEndpointsItem{" +
                        "feedbackEndpoint = '" + feedbackEndpoint + '\'' +
                        ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                        "}";
    }
}
