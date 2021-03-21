package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PtrackingUrl{

	@SerializedName("baseUrl")
	private String baseUrl;

	public void setBaseUrl(String baseUrl){
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl(){
		return baseUrl;
	}
}