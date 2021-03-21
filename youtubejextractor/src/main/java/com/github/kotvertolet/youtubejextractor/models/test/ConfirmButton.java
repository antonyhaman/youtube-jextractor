package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class ConfirmButton{

	@SerializedName("buttonRenderer")
	private ButtonRenderer buttonRenderer;

	public void setButtonRenderer(ButtonRenderer buttonRenderer){
		this.buttonRenderer = buttonRenderer;
	}

	public ButtonRenderer getButtonRenderer(){
		return buttonRenderer;
	}
}