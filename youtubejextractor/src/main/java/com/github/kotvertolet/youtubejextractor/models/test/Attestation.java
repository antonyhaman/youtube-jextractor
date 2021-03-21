package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Attestation{

	@SerializedName("playerAttestationRenderer")
	private PlayerAttestationRenderer playerAttestationRenderer;

	public void setPlayerAttestationRenderer(PlayerAttestationRenderer playerAttestationRenderer){
		this.playerAttestationRenderer = playerAttestationRenderer;
	}

	public PlayerAttestationRenderer getPlayerAttestationRenderer(){
		return playerAttestationRenderer;
	}
}