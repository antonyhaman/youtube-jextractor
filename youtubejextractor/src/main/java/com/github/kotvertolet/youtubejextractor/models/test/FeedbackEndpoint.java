package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class FeedbackEndpoint{

	@SerializedName("uiActions")
	private UiActions uiActions;

	@SerializedName("feedbackToken")
	private String feedbackToken;

	public void setUiActions(UiActions uiActions){
		this.uiActions = uiActions;
	}

	public UiActions getUiActions(){
		return uiActions;
	}

	public void setFeedbackToken(String feedbackToken){
		this.feedbackToken = feedbackToken;
	}

	public String getFeedbackToken(){
		return feedbackToken;
	}
}