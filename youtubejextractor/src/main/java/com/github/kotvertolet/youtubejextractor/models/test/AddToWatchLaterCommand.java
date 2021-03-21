package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class AddToWatchLaterCommand{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("playlistEditEndpoint")
	private PlaylistEditEndpoint playlistEditEndpoint;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setPlaylistEditEndpoint(PlaylistEditEndpoint playlistEditEndpoint){
		this.playlistEditEndpoint = playlistEditEndpoint;
	}

	public PlaylistEditEndpoint getPlaylistEditEndpoint(){
		return playlistEditEndpoint;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}
}