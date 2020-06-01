package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

public class MealbarPromoRenderer implements Serializable {

    private String triggerCondition;
    private String trackingParams;
    private List<ImpressionEndpointsItem> impressionEndpoints;
    private DismissButton dismissButton;
    private ActionButton actionButton;
    private List<MessageTextsItem> messageTexts;
    private MessageTitle messageTitle;
    private String style;
    private boolean isVisible;

    public String getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public String getTrackingParams() {
        return trackingParams;
    }

    public void setTrackingParams(String trackingParams) {
        this.trackingParams = trackingParams;
    }

    public List<ImpressionEndpointsItem> getImpressionEndpoints() {
        return impressionEndpoints;
    }

    public void setImpressionEndpoints(List<ImpressionEndpointsItem> impressionEndpoints) {
        this.impressionEndpoints = impressionEndpoints;
    }

    public DismissButton getDismissButton() {
        return dismissButton;
    }

    public void setDismissButton(DismissButton dismissButton) {
        this.dismissButton = dismissButton;
    }

    public ActionButton getActionButton() {
        return actionButton;
    }

    public void setActionButton(ActionButton actionButton) {
        this.actionButton = actionButton;
    }

    public List<MessageTextsItem> getMessageTexts() {
        return messageTexts;
    }

    public void setMessageTexts(List<MessageTextsItem> messageTexts) {
        this.messageTexts = messageTexts;
    }

    public MessageTitle getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(MessageTitle messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        return
                "MealbarPromoRenderer{" +
                        "triggerCondition = '" + triggerCondition + '\'' +
                        ",trackingParams = '" + trackingParams + '\'' +
                        ",impressionEndpoints = '" + impressionEndpoints + '\'' +
                        ",dismissButton = '" + dismissButton + '\'' +
                        ",actionButton = '" + actionButton + '\'' +
                        ",messageTexts = '" + messageTexts + '\'' +
                        ",messageTitle = '" + messageTitle + '\'' +
                        ",style = '" + style + '\'' +
                        ",isVisible = '" + isVisible + '\'' +
                        "}";
    }
}