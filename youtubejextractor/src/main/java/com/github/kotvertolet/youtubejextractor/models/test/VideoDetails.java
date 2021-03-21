package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VideoDetails{

	@SerializedName("isOwnerViewing")
	private boolean isOwnerViewing;

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("isLiveContent")
	private boolean isLiveContent;

	@SerializedName("keywords")
	private List<String> keywords;

	@SerializedName("author")
	private String author;

	@SerializedName("lengthSeconds")
	private String lengthSeconds;

	@SerializedName("videoId")
	private String videoId;

	@SerializedName("shortDescription")
	private String shortDescription;

	@SerializedName("isPrivate")
	private boolean isPrivate;

	@SerializedName("title")
	private String title;

	@SerializedName("isCrawlable")
	private boolean isCrawlable;

	@SerializedName("averageRating")
	private double averageRating;

	@SerializedName("isUnpluggedCorpus")
	private boolean isUnpluggedCorpus;

	@SerializedName("allowRatings")
	private boolean allowRatings;

	@SerializedName("viewCount")
	private String viewCount;

	@SerializedName("channelId")
	private String channelId;

	public void setIsOwnerViewing(boolean isOwnerViewing){
		this.isOwnerViewing = isOwnerViewing;
	}

	public boolean isIsOwnerViewing(){
		return isOwnerViewing;
	}

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setIsLiveContent(boolean isLiveContent){
		this.isLiveContent = isLiveContent;
	}

	public boolean isIsLiveContent(){
		return isLiveContent;
	}

	public void setKeywords(List<String> keywords){
		this.keywords = keywords;
	}

	public List<String> getKeywords(){
		return keywords;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setLengthSeconds(String lengthSeconds){
		this.lengthSeconds = lengthSeconds;
	}

	public String getLengthSeconds(){
		return lengthSeconds;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setIsPrivate(boolean isPrivate){
		this.isPrivate = isPrivate;
	}

	public boolean isIsPrivate(){
		return isPrivate;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setIsCrawlable(boolean isCrawlable){
		this.isCrawlable = isCrawlable;
	}

	public boolean isIsCrawlable(){
		return isCrawlable;
	}

	public void setAverageRating(double averageRating){
		this.averageRating = averageRating;
	}

	public double getAverageRating(){
		return averageRating;
	}

	public void setIsUnpluggedCorpus(boolean isUnpluggedCorpus){
		this.isUnpluggedCorpus = isUnpluggedCorpus;
	}

	public boolean isIsUnpluggedCorpus(){
		return isUnpluggedCorpus;
	}

	public void setAllowRatings(boolean allowRatings){
		this.allowRatings = allowRatings;
	}

	public boolean isAllowRatings(){
		return allowRatings;
	}

	public void setViewCount(String viewCount){
		this.viewCount = viewCount;
	}

	public String getViewCount(){
		return viewCount;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}
}