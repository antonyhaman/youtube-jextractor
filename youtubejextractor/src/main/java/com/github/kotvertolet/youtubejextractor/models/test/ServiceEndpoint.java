package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class ServiceEndpoint{

	@SerializedName("feedbackEndpoint")
	private FeedbackEndpoint feedbackEndpoint;

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	public void setFeedbackEndpoint(FeedbackEndpoint feedbackEndpoint){
		this.feedbackEndpoint = feedbackEndpoint;
	}

	public FeedbackEndpoint getFeedbackEndpoint(){
		return feedbackEndpoint;
	}

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}
}