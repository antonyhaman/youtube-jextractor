package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class CommandMetadata{

	@SerializedName("webCommandMetadata")
	private WebCommandMetadata webCommandMetadata;

	public void setWebCommandMetadata(WebCommandMetadata webCommandMetadata){
		this.webCommandMetadata = webCommandMetadata;
	}

	public WebCommandMetadata getWebCommandMetadata(){
		return webCommandMetadata;
	}
}