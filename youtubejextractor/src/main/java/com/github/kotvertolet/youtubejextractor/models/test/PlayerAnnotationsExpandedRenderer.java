package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlayerAnnotationsExpandedRenderer{

	@SerializedName("featuredChannel")
	private FeaturedChannel featuredChannel;

	@SerializedName("annotationId")
	private String annotationId;

	@SerializedName("allowSwipeDismiss")
	private boolean allowSwipeDismiss;

	public void setFeaturedChannel(FeaturedChannel featuredChannel){
		this.featuredChannel = featuredChannel;
	}

	public FeaturedChannel getFeaturedChannel(){
		return featuredChannel;
	}

	public void setAnnotationId(String annotationId){
		this.annotationId = annotationId;
	}

	public String getAnnotationId(){
		return annotationId;
	}

	public void setAllowSwipeDismiss(boolean allowSwipeDismiss){
		this.allowSwipeDismiss = allowSwipeDismiss;
	}

	public boolean isAllowSwipeDismiss(){
		return allowSwipeDismiss;
	}
}