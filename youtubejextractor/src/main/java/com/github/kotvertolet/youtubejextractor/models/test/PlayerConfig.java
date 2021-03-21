package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlayerConfig{

	@SerializedName("webPlayerConfig")
	private WebPlayerConfig webPlayerConfig;

	@SerializedName("mediaCommonConfig")
	private MediaCommonConfig mediaCommonConfig;

	@SerializedName("daiConfig")
	private DaiConfig daiConfig;

	@SerializedName("audioConfig")
	private AudioConfig audioConfig;

	@SerializedName("streamSelectionConfig")
	private StreamSelectionConfig streamSelectionConfig;

	public void setWebPlayerConfig(WebPlayerConfig webPlayerConfig){
		this.webPlayerConfig = webPlayerConfig;
	}

	public WebPlayerConfig getWebPlayerConfig(){
		return webPlayerConfig;
	}

	public void setMediaCommonConfig(MediaCommonConfig mediaCommonConfig){
		this.mediaCommonConfig = mediaCommonConfig;
	}

	public MediaCommonConfig getMediaCommonConfig(){
		return mediaCommonConfig;
	}

	public void setDaiConfig(DaiConfig daiConfig){
		this.daiConfig = daiConfig;
	}

	public DaiConfig getDaiConfig(){
		return daiConfig;
	}

	public void setAudioConfig(AudioConfig audioConfig){
		this.audioConfig = audioConfig;
	}

	public AudioConfig getAudioConfig(){
		return audioConfig;
	}

	public void setStreamSelectionConfig(StreamSelectionConfig streamSelectionConfig){
		this.streamSelectionConfig = streamSelectionConfig;
	}

	public StreamSelectionConfig getStreamSelectionConfig(){
		return streamSelectionConfig;
	}
}