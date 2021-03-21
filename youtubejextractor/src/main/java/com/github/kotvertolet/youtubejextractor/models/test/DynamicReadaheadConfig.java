package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class DynamicReadaheadConfig{

	@SerializedName("readAheadGrowthRateMs")
	private int readAheadGrowthRateMs;

	@SerializedName("maxReadAheadMediaTimeMs")
	private int maxReadAheadMediaTimeMs;

	@SerializedName("minReadAheadMediaTimeMs")
	private int minReadAheadMediaTimeMs;

	public void setReadAheadGrowthRateMs(int readAheadGrowthRateMs){
		this.readAheadGrowthRateMs = readAheadGrowthRateMs;
	}

	public int getReadAheadGrowthRateMs(){
		return readAheadGrowthRateMs;
	}

	public void setMaxReadAheadMediaTimeMs(int maxReadAheadMediaTimeMs){
		this.maxReadAheadMediaTimeMs = maxReadAheadMediaTimeMs;
	}

	public int getMaxReadAheadMediaTimeMs(){
		return maxReadAheadMediaTimeMs;
	}

	public void setMinReadAheadMediaTimeMs(int minReadAheadMediaTimeMs){
		this.minReadAheadMediaTimeMs = minReadAheadMediaTimeMs;
	}

	public int getMinReadAheadMediaTimeMs(){
		return minReadAheadMediaTimeMs;
	}
}