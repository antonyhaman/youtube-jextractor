package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class WebResponseContextExtensionData{

	@SerializedName("hasDecorated")
	private boolean hasDecorated;

	public void setHasDecorated(boolean hasDecorated){
		this.hasDecorated = hasDecorated;
	}

	public boolean isHasDecorated(){
		return hasDecorated;
	}
}