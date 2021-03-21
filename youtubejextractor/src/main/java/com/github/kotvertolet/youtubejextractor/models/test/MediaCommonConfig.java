package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class MediaCommonConfig{

	@SerializedName("dynamicReadaheadConfig")
	private DynamicReadaheadConfig dynamicReadaheadConfig;

	public void setDynamicReadaheadConfig(DynamicReadaheadConfig dynamicReadaheadConfig){
		this.dynamicReadaheadConfig = dynamicReadaheadConfig;
	}

	public DynamicReadaheadConfig getDynamicReadaheadConfig(){
		return dynamicReadaheadConfig;
	}
}