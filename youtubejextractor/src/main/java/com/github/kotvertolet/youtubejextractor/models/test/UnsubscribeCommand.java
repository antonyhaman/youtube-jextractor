package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class UnsubscribeCommand{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("unsubscribeEndpoint")
	private UnsubscribeEndpoint unsubscribeEndpoint;

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

	public void setUnsubscribeEndpoint(UnsubscribeEndpoint unsubscribeEndpoint){
		this.unsubscribeEndpoint = unsubscribeEndpoint;
	}

	public UnsubscribeEndpoint getUnsubscribeEndpoint(){
		return unsubscribeEndpoint;
	}
}