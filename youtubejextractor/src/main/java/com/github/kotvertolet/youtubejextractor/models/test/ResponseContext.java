package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseContext{

	@SerializedName("serviceTrackingParams")
	private List<ServiceTrackingParamsItem> serviceTrackingParams;

	@SerializedName("webResponseContextExtensionData")
	private WebResponseContextExtensionData webResponseContextExtensionData;

	@SerializedName("mainAppWebResponseContext")
	private MainAppWebResponseContext mainAppWebResponseContext;

	public void setServiceTrackingParams(List<ServiceTrackingParamsItem> serviceTrackingParams){
		this.serviceTrackingParams = serviceTrackingParams;
	}

	public List<ServiceTrackingParamsItem> getServiceTrackingParams(){
		return serviceTrackingParams;
	}

	public void setWebResponseContextExtensionData(WebResponseContextExtensionData webResponseContextExtensionData){
		this.webResponseContextExtensionData = webResponseContextExtensionData;
	}

	public WebResponseContextExtensionData getWebResponseContextExtensionData(){
		return webResponseContextExtensionData;
	}

	public void setMainAppWebResponseContext(MainAppWebResponseContext mainAppWebResponseContext){
		this.mainAppWebResponseContext = mainAppWebResponseContext;
	}

	public MainAppWebResponseContext getMainAppWebResponseContext(){
		return mainAppWebResponseContext;
	}
}