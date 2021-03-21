package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class SetAwesomeUrl{

	@SerializedName("baseUrl")
	private String baseUrl;

	@SerializedName("elapsedMediaTimeSeconds")
	private int elapsedMediaTimeSeconds;

	public void setBaseUrl(String baseUrl){
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl(){
		return baseUrl;
	}

	public void setElapsedMediaTimeSeconds(int elapsedMediaTimeSeconds){
		this.elapsedMediaTimeSeconds = elapsedMediaTimeSeconds;
	}

	public int getElapsedMediaTimeSeconds(){
		return elapsedMediaTimeSeconds;
	}
}