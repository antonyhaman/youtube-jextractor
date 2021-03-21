package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PlayerMicroformatRenderer{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("externalChannelId")
	private String externalChannelId;

	@SerializedName("publishDate")
	private String publishDate;

	@SerializedName("description")
	private Description description;

	@SerializedName("lengthSeconds")
	private String lengthSeconds;

	@SerializedName("title")
	private Title title;

	@SerializedName("hasYpcMetadata")
	private boolean hasYpcMetadata;

	@SerializedName("ownerChannelName")
	private String ownerChannelName;

	@SerializedName("uploadDate")
	private String uploadDate;

	@SerializedName("ownerProfileUrl")
	private String ownerProfileUrl;

	@SerializedName("isUnlisted")
	private boolean isUnlisted;

	@SerializedName("embed")
	private Embed embed;

	@SerializedName("viewCount")
	private String viewCount;

	@SerializedName("category")
	private String category;

	@SerializedName("isFamilySafe")
	private boolean isFamilySafe;

	@SerializedName("availableCountries")
	private List<String> availableCountries;

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setExternalChannelId(String externalChannelId){
		this.externalChannelId = externalChannelId;
	}

	public String getExternalChannelId(){
		return externalChannelId;
	}

	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}

	public String getPublishDate(){
		return publishDate;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setLengthSeconds(String lengthSeconds){
		this.lengthSeconds = lengthSeconds;
	}

	public String getLengthSeconds(){
		return lengthSeconds;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setHasYpcMetadata(boolean hasYpcMetadata){
		this.hasYpcMetadata = hasYpcMetadata;
	}

	public boolean isHasYpcMetadata(){
		return hasYpcMetadata;
	}

	public void setOwnerChannelName(String ownerChannelName){
		this.ownerChannelName = ownerChannelName;
	}

	public String getOwnerChannelName(){
		return ownerChannelName;
	}

	public void setUploadDate(String uploadDate){
		this.uploadDate = uploadDate;
	}

	public String getUploadDate(){
		return uploadDate;
	}

	public void setOwnerProfileUrl(String ownerProfileUrl){
		this.ownerProfileUrl = ownerProfileUrl;
	}

	public String getOwnerProfileUrl(){
		return ownerProfileUrl;
	}

	public void setIsUnlisted(boolean isUnlisted){
		this.isUnlisted = isUnlisted;
	}

	public boolean isIsUnlisted(){
		return isUnlisted;
	}

	public void setEmbed(Embed embed){
		this.embed = embed;
	}

	public Embed getEmbed(){
		return embed;
	}

	public void setViewCount(String viewCount){
		this.viewCount = viewCount;
	}

	public String getViewCount(){
		return viewCount;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setIsFamilySafe(boolean isFamilySafe){
		this.isFamilySafe = isFamilySafe;
	}

	public boolean isIsFamilySafe(){
		return isFamilySafe;
	}

	public void setAvailableCountries(List<String> availableCountries){
		this.availableCountries = availableCountries;
	}

	public List<String> getAvailableCountries(){
		return availableCountries;
	}
}