package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class ActionsItem{

	@SerializedName("openPopupAction")
	private OpenPopupAction openPopupAction;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	public void setOpenPopupAction(OpenPopupAction openPopupAction){
		this.openPopupAction = openPopupAction;
	}

	public OpenPopupAction getOpenPopupAction(){
		return openPopupAction;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}
}