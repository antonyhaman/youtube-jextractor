package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class AudioConfig{

	@SerializedName("perceptualLoudnessDb")
	private double perceptualLoudnessDb;

	@SerializedName("loudnessDb")
	private double loudnessDb;

	@SerializedName("enablePerFormatLoudness")
	private boolean enablePerFormatLoudness;

	public void setPerceptualLoudnessDb(double perceptualLoudnessDb){
		this.perceptualLoudnessDb = perceptualLoudnessDb;
	}

	public double getPerceptualLoudnessDb(){
		return perceptualLoudnessDb;
	}

	public void setLoudnessDb(double loudnessDb){
		this.loudnessDb = loudnessDb;
	}

	public double getLoudnessDb(){
		return loudnessDb;
	}

	public void setEnablePerFormatLoudness(boolean enablePerFormatLoudness){
		this.enablePerFormatLoudness = enablePerFormatLoudness;
	}

	public boolean isEnablePerFormatLoudness(){
		return enablePerFormatLoudness;
	}
}