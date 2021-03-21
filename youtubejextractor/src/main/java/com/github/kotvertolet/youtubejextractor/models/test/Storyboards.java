package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Storyboards{

	@SerializedName("playerStoryboardSpecRenderer")
	private PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer;

	public void setPlayerStoryboardSpecRenderer(PlayerStoryboardSpecRenderer playerStoryboardSpecRenderer){
		this.playerStoryboardSpecRenderer = playerStoryboardSpecRenderer;
	}

	public PlayerStoryboardSpecRenderer getPlayerStoryboardSpecRenderer(){
		return playerStoryboardSpecRenderer;
	}
}