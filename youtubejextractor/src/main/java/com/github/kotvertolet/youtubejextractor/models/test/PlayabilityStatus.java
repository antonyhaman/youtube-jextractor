package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlayabilityStatus{

	@SerializedName("playableInEmbed")
	private boolean playableInEmbed;

	@SerializedName("contextParams")
	private String contextParams;

	@SerializedName("miniplayer")
	private Miniplayer miniplayer;

	@SerializedName("status")
	private String status;

	public void setPlayableInEmbed(boolean playableInEmbed){
		this.playableInEmbed = playableInEmbed;
	}

	public boolean isPlayableInEmbed(){
		return playableInEmbed;
	}

	public void setContextParams(String contextParams){
		this.contextParams = contextParams;
	}

	public String getContextParams(){
		return contextParams;
	}

	public void setMiniplayer(Miniplayer miniplayer){
		this.miniplayer = miniplayer;
	}

	public Miniplayer getMiniplayer(){
		return miniplayer;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}