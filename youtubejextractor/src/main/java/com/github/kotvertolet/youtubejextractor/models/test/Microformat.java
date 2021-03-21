package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Microformat{

	@SerializedName("playerMicroformatRenderer")
	private PlayerMicroformatRenderer playerMicroformatRenderer;

	public void setPlayerMicroformatRenderer(PlayerMicroformatRenderer playerMicroformatRenderer){
		this.playerMicroformatRenderer = playerMicroformatRenderer;
	}

	public PlayerMicroformatRenderer getPlayerMicroformatRenderer(){
		return playerMicroformatRenderer;
	}
}