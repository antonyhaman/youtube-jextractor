package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class FeaturedChannel{

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("watermark")
	private Watermark watermark;

	@SerializedName("subscribeButton")
	private SubscribeButton subscribeButton;

	@SerializedName("startTimeMs")
	private String startTimeMs;

	@SerializedName("channelName")
	private String channelName;

	@SerializedName("endTimeMs")
	private String endTimeMs;

	@SerializedName("navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setWatermark(Watermark watermark){
		this.watermark = watermark;
	}

	public Watermark getWatermark(){
		return watermark;
	}

	public void setSubscribeButton(SubscribeButton subscribeButton){
		this.subscribeButton = subscribeButton;
	}

	public SubscribeButton getSubscribeButton(){
		return subscribeButton;
	}

	public void setStartTimeMs(String startTimeMs){
		this.startTimeMs = startTimeMs;
	}

	public String getStartTimeMs(){
		return startTimeMs;
	}

	public void setChannelName(String channelName){
		this.channelName = channelName;
	}

	public String getChannelName(){
		return channelName;
	}

	public void setEndTimeMs(String endTimeMs){
		this.endTimeMs = endTimeMs;
	}

	public String getEndTimeMs(){
		return endTimeMs;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}
}