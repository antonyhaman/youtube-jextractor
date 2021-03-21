package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("playerConfig")
	private PlayerConfig playerConfig;

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("attestation")
	private Attestation attestation;

	@SerializedName("videoDetails")
	private VideoDetails videoDetails;

	@SerializedName("streamingData")
	private StreamingData streamingData;

	@SerializedName("responseContext")
	private ResponseContext responseContext;

	@SerializedName("playabilityStatus")
	private PlayabilityStatus playabilityStatus;

	@SerializedName("annotations")
	private List<AnnotationsItem> annotations;

	@SerializedName("messages")
	private List<MessagesItem> messages;

	@SerializedName("playbackTracking")
	private PlaybackTracking playbackTracking;

	@SerializedName("microformat")
	private Microformat microformat;

	@SerializedName("storyboards")
	private Storyboards storyboards;

	public void setPlayerConfig(PlayerConfig playerConfig){
		this.playerConfig = playerConfig;
	}

	public PlayerConfig getPlayerConfig(){
		return playerConfig;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setAttestation(Attestation attestation){
		this.attestation = attestation;
	}

	public Attestation getAttestation(){
		return attestation;
	}

	public void setVideoDetails(VideoDetails videoDetails){
		this.videoDetails = videoDetails;
	}

	public VideoDetails getVideoDetails(){
		return videoDetails;
	}

	public void setStreamingData(StreamingData streamingData){
		this.streamingData = streamingData;
	}

	public StreamingData getStreamingData(){
		return streamingData;
	}

	public void setResponseContext(ResponseContext responseContext){
		this.responseContext = responseContext;
	}

	public ResponseContext getResponseContext(){
		return responseContext;
	}

	public void setPlayabilityStatus(PlayabilityStatus playabilityStatus){
		this.playabilityStatus = playabilityStatus;
	}

	public PlayabilityStatus getPlayabilityStatus(){
		return playabilityStatus;
	}

	public void setAnnotations(List<AnnotationsItem> annotations){
		this.annotations = annotations;
	}

	public List<AnnotationsItem> getAnnotations(){
		return annotations;
	}

	public void setMessages(List<MessagesItem> messages){
		this.messages = messages;
	}

	public List<MessagesItem> getMessages(){
		return messages;
	}

	public void setPlaybackTracking(PlaybackTracking playbackTracking){
		this.playbackTracking = playbackTracking;
	}

	public PlaybackTracking getPlaybackTracking(){
		return playbackTracking;
	}

	public void setMicroformat(Microformat microformat){
		this.microformat = microformat;
	}

	public Microformat getMicroformat(){
		return microformat;
	}

	public void setStoryboards(Storyboards storyboards){
		this.storyboards = storyboards;
	}

	public Storyboards getStoryboards(){
		return storyboards;
	}
}