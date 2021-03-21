package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class WebPlayerConfig{

	@SerializedName("webPlayerActionsPorting")
	private WebPlayerActionsPorting webPlayerActionsPorting;

	public void setWebPlayerActionsPorting(WebPlayerActionsPorting webPlayerActionsPorting){
		this.webPlayerActionsPorting = webPlayerActionsPorting;
	}

	public WebPlayerActionsPorting getWebPlayerActionsPorting(){
		return webPlayerActionsPorting;
	}
}