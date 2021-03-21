package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MealbarPromoRenderer{

	@SerializedName("triggerCondition")
	private String triggerCondition;

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("impressionEndpoints")
	private List<ImpressionEndpointsItem> impressionEndpoints;

	@SerializedName("dismissButton")
	private DismissButton dismissButton;

	@SerializedName("icon")
	private Icon icon;

	@SerializedName("actionButton")
	private ActionButton actionButton;

	@SerializedName("messageTexts")
	private List<MessageTextsItem> messageTexts;

	@SerializedName("messageTitle")
	private MessageTitle messageTitle;

	@SerializedName("style")
	private String style;

	@SerializedName("isVisible")
	private boolean isVisible;

	public void setTriggerCondition(String triggerCondition){
		this.triggerCondition = triggerCondition;
	}

	public String getTriggerCondition(){
		return triggerCondition;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setImpressionEndpoints(List<ImpressionEndpointsItem> impressionEndpoints){
		this.impressionEndpoints = impressionEndpoints;
	}

	public List<ImpressionEndpointsItem> getImpressionEndpoints(){
		return impressionEndpoints;
	}

	public void setDismissButton(DismissButton dismissButton){
		this.dismissButton = dismissButton;
	}

	public DismissButton getDismissButton(){
		return dismissButton;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setActionButton(ActionButton actionButton){
		this.actionButton = actionButton;
	}

	public ActionButton getActionButton(){
		return actionButton;
	}

	public void setMessageTexts(List<MessageTextsItem> messageTexts){
		this.messageTexts = messageTexts;
	}

	public List<MessageTextsItem> getMessageTexts(){
		return messageTexts;
	}

	public void setMessageTitle(MessageTitle messageTitle){
		this.messageTitle = messageTitle;
	}

	public MessageTitle getMessageTitle(){
		return messageTitle;
	}

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setIsVisible(boolean isVisible){
		this.isVisible = isVisible;
	}

	public boolean isIsVisible(){
		return isVisible;
	}
}