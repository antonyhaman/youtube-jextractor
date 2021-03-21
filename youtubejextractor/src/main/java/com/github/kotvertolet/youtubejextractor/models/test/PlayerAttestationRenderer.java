package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlayerAttestationRenderer{

	@SerializedName("botguardData")
	private BotguardData botguardData;

	@SerializedName("challenge")
	private String challenge;

	public void setBotguardData(BotguardData botguardData){
		this.botguardData = botguardData;
	}

	public BotguardData getBotguardData(){
		return botguardData;
	}

	public void setChallenge(String challenge){
		this.challenge = challenge;
	}

	public String getChallenge(){
		return challenge;
	}
}