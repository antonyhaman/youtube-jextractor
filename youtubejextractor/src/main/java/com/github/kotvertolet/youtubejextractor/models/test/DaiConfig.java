package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class DaiConfig{

	@SerializedName("enableServerStitchedDai")
	private boolean enableServerStitchedDai;

	public void setEnableServerStitchedDai(boolean enableServerStitchedDai){
		this.enableServerStitchedDai = enableServerStitchedDai;
	}

	public boolean isEnableServerStitchedDai(){
		return enableServerStitchedDai;
	}
}