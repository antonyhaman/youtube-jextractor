package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class StreamSelectionConfig{

	@SerializedName("maxBitrate")
	private String maxBitrate;

	public void setMaxBitrate(String maxBitrate){
		this.maxBitrate = maxBitrate;
	}

	public String getMaxBitrate(){
		return maxBitrate;
	}
}