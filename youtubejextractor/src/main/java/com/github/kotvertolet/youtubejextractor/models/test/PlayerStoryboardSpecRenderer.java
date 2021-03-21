package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlayerStoryboardSpecRenderer{

	@SerializedName("spec")
	private String spec;

	public void setSpec(String spec){
		this.spec = spec;
	}

	public String getSpec(){
		return spec;
	}
}