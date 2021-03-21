package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class AnnotationsItem{

	@SerializedName("playerAnnotationsExpandedRenderer")
	private PlayerAnnotationsExpandedRenderer playerAnnotationsExpandedRenderer;

	public void setPlayerAnnotationsExpandedRenderer(PlayerAnnotationsExpandedRenderer playerAnnotationsExpandedRenderer){
		this.playerAnnotationsExpandedRenderer = playerAnnotationsExpandedRenderer;
	}

	public PlayerAnnotationsExpandedRenderer getPlayerAnnotationsExpandedRenderer(){
		return playerAnnotationsExpandedRenderer;
	}
}