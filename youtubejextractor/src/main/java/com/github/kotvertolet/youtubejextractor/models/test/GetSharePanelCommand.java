package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class GetSharePanelCommand{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("webPlayerShareEntityServiceEndpoint")
	private WebPlayerShareEntityServiceEndpoint webPlayerShareEntityServiceEndpoint;

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

	public void setWebPlayerShareEntityServiceEndpoint(WebPlayerShareEntityServiceEndpoint webPlayerShareEntityServiceEndpoint){
		this.webPlayerShareEntityServiceEndpoint = webPlayerShareEntityServiceEndpoint;
	}

	public WebPlayerShareEntityServiceEndpoint getWebPlayerShareEntityServiceEndpoint(){
		return webPlayerShareEntityServiceEndpoint;
	}
}