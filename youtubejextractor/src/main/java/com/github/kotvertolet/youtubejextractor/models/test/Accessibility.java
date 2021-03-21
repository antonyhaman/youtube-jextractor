package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Accessibility{

	@SerializedName("label")
	private String label;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}
}