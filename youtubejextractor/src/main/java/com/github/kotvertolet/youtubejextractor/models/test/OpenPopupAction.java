package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class OpenPopupAction{

	@SerializedName("popupType")
	private String popupType;

	@SerializedName("popup")
	private Popup popup;

	public void setPopupType(String popupType){
		this.popupType = popupType;
	}

	public String getPopupType(){
		return popupType;
	}

	public void setPopup(Popup popup){
		this.popup = popup;
	}

	public Popup getPopup(){
		return popup;
	}
}