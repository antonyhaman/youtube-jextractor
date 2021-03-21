package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class WebCommandMetadata{

	@SerializedName("apiUrl")
	private String apiUrl;

	@SerializedName("rootVe")
	private int rootVe;

	@SerializedName("webPageType")
	private String webPageType;

	@SerializedName("url")
	private String url;

	@SerializedName("sendPost")
	private boolean sendPost;

	public void setApiUrl(String apiUrl){
		this.apiUrl = apiUrl;
	}

	public String getApiUrl(){
		return apiUrl;
	}

	public void setRootVe(int rootVe){
		this.rootVe = rootVe;
	}

	public int getRootVe(){
		return rootVe;
	}

	public void setWebPageType(String webPageType){
		this.webPageType = webPageType;
	}

	public String getWebPageType(){
		return webPageType;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setSendPost(boolean sendPost){
		this.sendPost = sendPost;
	}

	public boolean isSendPost(){
		return sendPost;
	}
}