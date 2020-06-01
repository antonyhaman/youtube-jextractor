package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

public class PlayerMicroformatRenderer implements Serializable {
    private Thumbnail thumbnail;
    private String ownerGplusProfileUrl;
    private String externalChannelId;
    private String publishDate;
    private Description description;
    private String lengthSeconds;
    private Title title;
    private boolean hasYpcMetadata;
    private String ownerChannelName;
    private String uploadDate;
    private String ownerProfileUrl;
    private boolean isUnlisted;
    private Embed embed;
    private String viewCount;
    private String category;
    private boolean isFamilySafe;
    private List<String> availableCountries;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getOwnerGplusProfileUrl() {
        return ownerGplusProfileUrl;
    }

    public void setOwnerGplusProfileUrl(String ownerGplusProfileUrl) {
        this.ownerGplusProfileUrl = ownerGplusProfileUrl;
    }

    public String getExternalChannelId() {
        return externalChannelId;
    }

    public void setExternalChannelId(String externalChannelId) {
        this.externalChannelId = externalChannelId;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getLengthSeconds() {
        return lengthSeconds;
    }

    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public boolean isHasYpcMetadata() {
        return hasYpcMetadata;
    }

    public void setHasYpcMetadata(boolean hasYpcMetadata) {
        this.hasYpcMetadata = hasYpcMetadata;
    }

    public String getOwnerChannelName() {
        return ownerChannelName;
    }

    public void setOwnerChannelName(String ownerChannelName) {
        this.ownerChannelName = ownerChannelName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getOwnerProfileUrl() {
        return ownerProfileUrl;
    }

    public void setOwnerProfileUrl(String ownerProfileUrl) {
        this.ownerProfileUrl = ownerProfileUrl;
    }

    public boolean isIsUnlisted() {
        return isUnlisted;
    }

    public void setIsUnlisted(boolean isUnlisted) {
        this.isUnlisted = isUnlisted;
    }

    public Embed getEmbed() {
        return embed;
    }

    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIsFamilySafe() {
        return isFamilySafe;
    }

    public void setIsFamilySafe(boolean isFamilySafe) {
        this.isFamilySafe = isFamilySafe;
    }

    public List<String> getAvailableCountries() {
        return availableCountries;
    }

    public void setAvailableCountries(List<String> availableCountries) {
        this.availableCountries = availableCountries;
    }

    @Override
    public String toString() {
        return
                "PlayerMicroformatRenderer{" +
                        "thumbnail = '" + thumbnail + '\'' +
                        ",ownerGplusProfileUrl = '" + ownerGplusProfileUrl + '\'' +
                        ",externalChannelId = '" + externalChannelId + '\'' +
                        ",publishDate = '" + publishDate + '\'' +
                        ",description = '" + description + '\'' +
                        ",lengthSeconds = '" + lengthSeconds + '\'' +
                        ",title = '" + title + '\'' +
                        ",hasYpcMetadata = '" + hasYpcMetadata + '\'' +
                        ",ownerChannelName = '" + ownerChannelName + '\'' +
                        ",uploadDate = '" + uploadDate + '\'' +
                        ",ownerProfileUrl = '" + ownerProfileUrl + '\'' +
                        ",isUnlisted = '" + isUnlisted + '\'' +
                        ",embed = '" + embed + '\'' +
                        ",viewCount = '" + viewCount + '\'' +
                        ",category = '" + category + '\'' +
                        ",isFamilySafe = '" + isFamilySafe + '\'' +
                        ",availableCountries = '" + availableCountries + '\'' +
                        "}";
    }
}