package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class ServiceEndpointsItem{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("signalServiceEndpoint")
	private SignalServiceEndpoint signalServiceEndpoint;

	@SerializedName("subscribeEndpoint")
	private SubscribeEndpoint subscribeEndpoint;

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

	public void setSignalServiceEndpoint(SignalServiceEndpoint signalServiceEndpoint){
		this.signalServiceEndpoint = signalServiceEndpoint;
	}

	public SignalServiceEndpoint getSignalServiceEndpoint(){
		return signalServiceEndpoint;
	}

	public void setSubscribeEndpoint(SubscribeEndpoint subscribeEndpoint){
		this.subscribeEndpoint = subscribeEndpoint;
	}

	public SubscribeEndpoint getSubscribeEndpoint(){
		return subscribeEndpoint;
	}
}