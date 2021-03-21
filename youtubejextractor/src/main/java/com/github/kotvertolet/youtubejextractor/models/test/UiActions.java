package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class UiActions{

	@SerializedName("hideEnclosingContainer")
	private boolean hideEnclosingContainer;

	public void setHideEnclosingContainer(boolean hideEnclosingContainer){
		this.hideEnclosingContainer = hideEnclosingContainer;
	}

	public boolean isHideEnclosingContainer(){
		return hideEnclosingContainer;
	}
}