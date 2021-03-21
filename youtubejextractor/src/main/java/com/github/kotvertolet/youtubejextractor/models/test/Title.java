package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Title{

	@SerializedName("simpleText")
	private String simpleText;

	public void setSimpleText(String simpleText){
		this.simpleText = simpleText;
	}

	public String getSimpleText(){
		return simpleText;
	}
}