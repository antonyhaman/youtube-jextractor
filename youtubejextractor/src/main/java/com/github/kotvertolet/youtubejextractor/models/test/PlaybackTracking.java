package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class PlaybackTracking{

	@SerializedName("videostatsWatchtimeUrl")
	private VideostatsWatchtimeUrl videostatsWatchtimeUrl;

	@SerializedName("videostatsDelayplayUrl")
	private VideostatsDelayplayUrl videostatsDelayplayUrl;

	@SerializedName("qoeUrl")
	private QoeUrl qoeUrl;

	@SerializedName("youtubeRemarketingUrl")
	private YoutubeRemarketingUrl youtubeRemarketingUrl;

	@SerializedName("googleRemarketingUrl")
	private GoogleRemarketingUrl googleRemarketingUrl;

	@SerializedName("setAwesomeUrl")
	private SetAwesomeUrl setAwesomeUrl;

	@SerializedName("videostatsPlaybackUrl")
	private VideostatsPlaybackUrl videostatsPlaybackUrl;

	@SerializedName("ptrackingUrl")
	private PtrackingUrl ptrackingUrl;

	@SerializedName("atrUrl")
	private AtrUrl atrUrl;

	public void setVideostatsWatchtimeUrl(VideostatsWatchtimeUrl videostatsWatchtimeUrl){
		this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
	}

	public VideostatsWatchtimeUrl getVideostatsWatchtimeUrl(){
		return videostatsWatchtimeUrl;
	}

	public void setVideostatsDelayplayUrl(VideostatsDelayplayUrl videostatsDelayplayUrl){
		this.videostatsDelayplayUrl = videostatsDelayplayUrl;
	}

	public VideostatsDelayplayUrl getVideostatsDelayplayUrl(){
		return videostatsDelayplayUrl;
	}

	public void setQoeUrl(QoeUrl qoeUrl){
		this.qoeUrl = qoeUrl;
	}

	public QoeUrl getQoeUrl(){
		return qoeUrl;
	}

	public void setYoutubeRemarketingUrl(YoutubeRemarketingUrl youtubeRemarketingUrl){
		this.youtubeRemarketingUrl = youtubeRemarketingUrl;
	}

	public YoutubeRemarketingUrl getYoutubeRemarketingUrl(){
		return youtubeRemarketingUrl;
	}

	public void setGoogleRemarketingUrl(GoogleRemarketingUrl googleRemarketingUrl){
		this.googleRemarketingUrl = googleRemarketingUrl;
	}

	public GoogleRemarketingUrl getGoogleRemarketingUrl(){
		return googleRemarketingUrl;
	}

	public void setSetAwesomeUrl(SetAwesomeUrl setAwesomeUrl){
		this.setAwesomeUrl = setAwesomeUrl;
	}

	public SetAwesomeUrl getSetAwesomeUrl(){
		return setAwesomeUrl;
	}

	public void setVideostatsPlaybackUrl(VideostatsPlaybackUrl videostatsPlaybackUrl){
		this.videostatsPlaybackUrl = videostatsPlaybackUrl;
	}

	public VideostatsPlaybackUrl getVideostatsPlaybackUrl(){
		return videostatsPlaybackUrl;
	}

	public void setPtrackingUrl(PtrackingUrl ptrackingUrl){
		this.ptrackingUrl = ptrackingUrl;
	}

	public PtrackingUrl getPtrackingUrl(){
		return ptrackingUrl;
	}

	public void setAtrUrl(AtrUrl atrUrl){
		this.atrUrl = atrUrl;
	}

	public AtrUrl getAtrUrl(){
		return atrUrl;
	}
}