package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UnsubscribeEndpoint{

	@SerializedName("channelIds")
	private List<String> channelIds;

	@SerializedName("params")
	private String params;

	public void setChannelIds(List<String> channelIds){
		this.channelIds = channelIds;
	}

	public List<String> getChannelIds(){
		return channelIds;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}
}