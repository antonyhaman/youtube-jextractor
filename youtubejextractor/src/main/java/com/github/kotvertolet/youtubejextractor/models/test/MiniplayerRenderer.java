package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class MiniplayerRenderer{

	@SerializedName("playbackMode")
	private String playbackMode;

	public void setPlaybackMode(String playbackMode){
		this.playbackMode = playbackMode;
	}

	public String getPlaybackMode(){
		return playbackMode;
	}
}