package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class WebPlayerShareEntityServiceEndpoint{

	@SerializedName("serializedShareEntity")
	private String serializedShareEntity;

	public void setSerializedShareEntity(String serializedShareEntity){
		this.serializedShareEntity = serializedShareEntity;
	}

	public String getSerializedShareEntity(){
		return serializedShareEntity;
	}
}