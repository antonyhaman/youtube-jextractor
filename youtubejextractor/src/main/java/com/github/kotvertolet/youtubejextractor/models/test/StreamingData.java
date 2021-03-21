package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StreamingData{

	@SerializedName("formats")
	private List<FormatsItem> formats;

	@SerializedName("dashManifestUrl")
	private String dashManifestUrl;

	@SerializedName("adaptiveFormats")
	private List<AdaptiveFormatsItem> adaptiveFormats;

	@SerializedName("expiresInSeconds")
	private String expiresInSeconds;

	public void setFormats(List<FormatsItem> formats){
		this.formats = formats;
	}

	public List<FormatsItem> getFormats(){
		return formats;
	}

	public void setDashManifestUrl(String dashManifestUrl){
		this.dashManifestUrl = dashManifestUrl;
	}

	public String getDashManifestUrl(){
		return dashManifestUrl;
	}

	public void setAdaptiveFormats(List<AdaptiveFormatsItem> adaptiveFormats){
		this.adaptiveFormats = adaptiveFormats;
	}

	public List<AdaptiveFormatsItem> getAdaptiveFormats(){
		return adaptiveFormats;
	}

	public void setExpiresInSeconds(String expiresInSeconds){
		this.expiresInSeconds = expiresInSeconds;
	}

	public String getExpiresInSeconds(){
		return expiresInSeconds;
	}
}