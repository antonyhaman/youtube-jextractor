package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Miniplayer{

	@SerializedName("miniplayerRenderer")
	private MiniplayerRenderer miniplayerRenderer;

	public void setMiniplayerRenderer(MiniplayerRenderer miniplayerRenderer){
		this.miniplayerRenderer = miniplayerRenderer;
	}

	public MiniplayerRenderer getMiniplayerRenderer(){
		return miniplayerRenderer;
	}
}