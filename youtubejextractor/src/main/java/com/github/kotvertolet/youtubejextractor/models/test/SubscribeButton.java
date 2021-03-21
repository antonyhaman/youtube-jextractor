package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class SubscribeButton{

	@SerializedName("subscribeButtonRenderer")
	private SubscribeButtonRenderer subscribeButtonRenderer;

	public void setSubscribeButtonRenderer(SubscribeButtonRenderer subscribeButtonRenderer){
		this.subscribeButtonRenderer = subscribeButtonRenderer;
	}

	public SubscribeButtonRenderer getSubscribeButtonRenderer(){
		return subscribeButtonRenderer;
	}
}