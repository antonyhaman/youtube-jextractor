package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class MainAppWebResponseContext{

	@SerializedName("loggedOut")
	private boolean loggedOut;

	public void setLoggedOut(boolean loggedOut){
		this.loggedOut = loggedOut;
	}

	public boolean isLoggedOut(){
		return loggedOut;
	}
}