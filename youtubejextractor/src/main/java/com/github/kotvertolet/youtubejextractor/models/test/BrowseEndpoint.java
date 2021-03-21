package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class BrowseEndpoint{

	@SerializedName("browseId")
	private String browseId;

	@SerializedName("params")
	private String params;

	public void setBrowseId(String browseId){
		this.browseId = browseId;
	}

	public String getBrowseId(){
		return browseId;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}
}