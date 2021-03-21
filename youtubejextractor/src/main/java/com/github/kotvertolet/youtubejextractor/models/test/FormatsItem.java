package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class FormatsItem{

	@SerializedName("itag")
	private int itag;

	@SerializedName("fps")
	private int fps;

	@SerializedName("projectionType")
	private String projectionType;

	@SerializedName("bitrate")
	private int bitrate;

	@SerializedName("mimeType")
	private String mimeType;

	@SerializedName("audioQuality")
	private String audioQuality;

	@SerializedName("approxDurationMs")
	private String approxDurationMs;

	@SerializedName("url")
	private String url;

	@SerializedName("audioSampleRate")
	private String audioSampleRate;

	@SerializedName("quality")
	private String quality;

	@SerializedName("qualityLabel")
	private String qualityLabel;

	@SerializedName("audioChannels")
	private int audioChannels;

	@SerializedName("width")
	private int width;

	@SerializedName("lastModified")
	private String lastModified;

	@SerializedName("height")
	private int height;

	@SerializedName("contentLength")
	private String contentLength;

	@SerializedName("averageBitrate")
	private int averageBitrate;

	public void setItag(int itag){
		this.itag = itag;
	}

	public int getItag(){
		return itag;
	}

	public void setFps(int fps){
		this.fps = fps;
	}

	public int getFps(){
		return fps;
	}

	public void setProjectionType(String projectionType){
		this.projectionType = projectionType;
	}

	public String getProjectionType(){
		return projectionType;
	}

	public void setBitrate(int bitrate){
		this.bitrate = bitrate;
	}

	public int getBitrate(){
		return bitrate;
	}

	public void setMimeType(String mimeType){
		this.mimeType = mimeType;
	}

	public String getMimeType(){
		return mimeType;
	}

	public void setAudioQuality(String audioQuality){
		this.audioQuality = audioQuality;
	}

	public String getAudioQuality(){
		return audioQuality;
	}

	public void setApproxDurationMs(String approxDurationMs){
		this.approxDurationMs = approxDurationMs;
	}

	public String getApproxDurationMs(){
		return approxDurationMs;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAudioSampleRate(String audioSampleRate){
		this.audioSampleRate = audioSampleRate;
	}

	public String getAudioSampleRate(){
		return audioSampleRate;
	}

	public void setQuality(String quality){
		this.quality = quality;
	}

	public String getQuality(){
		return quality;
	}

	public void setQualityLabel(String qualityLabel){
		this.qualityLabel = qualityLabel;
	}

	public String getQualityLabel(){
		return qualityLabel;
	}

	public void setAudioChannels(int audioChannels){
		this.audioChannels = audioChannels;
	}

	public int getAudioChannels(){
		return audioChannels;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setLastModified(String lastModified){
		this.lastModified = lastModified;
	}

	public String getLastModified(){
		return lastModified;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setContentLength(String contentLength){
		this.contentLength = contentLength;
	}

	public String getContentLength(){
		return contentLength;
	}

	public void setAverageBitrate(int averageBitrate){
		this.averageBitrate = averageBitrate;
	}

	public int getAverageBitrate(){
		return averageBitrate;
	}
}