package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class ButtonRenderer{

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("size")
	private String size;

	@SerializedName("style")
	private String style;

	@SerializedName("text")
	private Text text;

	@SerializedName("serviceEndpoint")
	private ServiceEndpoint serviceEndpoint;

	@SerializedName("navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setText(Text text){
		this.text = text;
	}

	public Text getText(){
		return text;
	}

	public void setServiceEndpoint(ServiceEndpoint serviceEndpoint){
		this.serviceEndpoint = serviceEndpoint;
	}

	public ServiceEndpoint getServiceEndpoint(){
		return serviceEndpoint;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}
}