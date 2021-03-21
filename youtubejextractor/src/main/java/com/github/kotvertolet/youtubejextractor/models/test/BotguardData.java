package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class BotguardData{

	@SerializedName("interpreterUrl")
	private String interpreterUrl;

	@SerializedName("program")
	private String program;

	public void setInterpreterUrl(String interpreterUrl){
		this.interpreterUrl = interpreterUrl;
	}

	public String getInterpreterUrl(){
		return interpreterUrl;
	}

	public void setProgram(String program){
		this.program = program;
	}

	public String getProgram(){
		return program;
	}
}