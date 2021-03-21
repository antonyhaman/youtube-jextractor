package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ServiceTrackingParamsItem{

	@SerializedName("service")
	private String service;

	@SerializedName("params")
	private List<ParamsItem> params;

	public void setService(String service){
		this.service = service;
	}

	public String getService(){
		return service;
	}

	public void setParams(List<ParamsItem> params){
		this.params = params;
	}

	public List<ParamsItem> getParams(){
		return params;
	}
}