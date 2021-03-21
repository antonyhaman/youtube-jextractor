package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class SubscribeCommand{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("subscribeEndpoint")
	private SubscribeEndpoint subscribeEndpoint;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setSubscribeEndpoint(SubscribeEndpoint subscribeEndpoint){
		this.subscribeEndpoint = subscribeEndpoint;
	}

	public SubscribeEndpoint getSubscribeEndpoint(){
		return subscribeEndpoint;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}
}