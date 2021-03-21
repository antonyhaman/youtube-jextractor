package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Embed{

	@SerializedName("width")
	private int width;

	@SerializedName("flashUrl")
	private String flashUrl;

	@SerializedName("flashSecureUrl")
	private String flashSecureUrl;

	@SerializedName("iframeUrl")
	private String iframeUrl;

	@SerializedName("height")
	private int height;

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setFlashUrl(String flashUrl){
		this.flashUrl = flashUrl;
	}

	public String getFlashUrl(){
		return flashUrl;
	}

	public void setFlashSecureUrl(String flashSecureUrl){
		this.flashSecureUrl = flashSecureUrl;
	}

	public String getFlashSecureUrl(){
		return flashSecureUrl;
	}

	public void setIframeUrl(String iframeUrl){
		this.iframeUrl = iframeUrl;
	}

	public String getIframeUrl(){
		return iframeUrl;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}