package com.github.kotvertolet.pojo.youtubeInnerData;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VideoDetails {

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

    public void setIsOwnerViewing(boolean isOwnerViewing) {
        this.isOwnerViewing = isOwnerViewing;
    }

    public boolean isIsOwnerViewing() {
        return isOwnerViewing;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setIsLiveContent(boolean isLiveContent) {
        this.isLiveContent = isLiveContent;
    }

    public boolean isIsLiveContent() {
        return isLiveContent;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public String getLengthSeconds() {
        return lengthSeconds;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIsCrawlable(boolean isCrawlable) {
        this.isCrawlable = isCrawlable;
    }

    public boolean isIsCrawlable() {
        return isCrawlable;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setIsUnpluggedCorpus(boolean isUnpluggedCorpus) {
        this.isUnpluggedCorpus = isUnpluggedCorpus;
    }

    public boolean isIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }

    public void setAllowRatings(boolean allowRatings) {
        this.allowRatings = allowRatings;
    }

    public boolean isAllowRatings() {
        return allowRatings;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    @Override
    public String toString() {
        return
                "VideoDetails{" +
                        "isOwnerViewing = '" + isOwnerViewing + '\'' +
                        ",thumbnail = '" + thumbnail + '\'' +
                        ",isLiveContent = '" + isLiveContent + '\'' +
                        ",keywords = '" + keywords + '\'' +
                        ",author = '" + author + '\'' +
                        ",lengthSeconds = '" + lengthSeconds + '\'' +
                        ",videoId = '" + videoId + '\'' +
                        ",shortDescription = '" + shortDescription + '\'' +
                        ",isPrivate = '" + isPrivate + '\'' +
                        ",title = '" + title + '\'' +
                        ",isCrawlable = '" + isCrawlable + '\'' +
                        ",averageRating = '" + averageRating + '\'' +
                        ",isUnpluggedCorpus = '" + isUnpluggedCorpus + '\'' +
                        ",allowRatings = '" + allowRatings + '\'' +
                        ",viewCount = '" + viewCount + '\'' +
                        ",channelId = '" + channelId + '\'' +
                        "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoDetails)) return false;

        VideoDetails that = (VideoDetails) o;

        if (isOwnerViewing != that.isOwnerViewing) return false;
        if (isLiveContent != that.isLiveContent) return false;
        if (isPrivate != that.isPrivate) return false;
        if (isCrawlable != that.isCrawlable) return false;
        if (Double.compare(that.averageRating, averageRating) != 0) return false;
        if (isUnpluggedCorpus != that.isUnpluggedCorpus) return false;
        if (allowRatings != that.allowRatings) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null)
            return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null)
            return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (lengthSeconds != null ? !lengthSeconds.equals(that.lengthSeconds) : that.lengthSeconds != null)
            return false;
        if (videoId != null ? !videoId.equals(that.videoId) : that.videoId != null) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (viewCount != null ? !viewCount.equals(that.viewCount) : that.viewCount != null)
            return false;
        return channelId != null ? channelId.equals(that.channelId) : that.channelId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (isOwnerViewing ? 1 : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (isLiveContent ? 1 : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (lengthSeconds != null ? lengthSeconds.hashCode() : 0);
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (isPrivate ? 1 : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isCrawlable ? 1 : 0);
        temp = Double.doubleToLongBits(averageRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isUnpluggedCorpus ? 1 : 0);
        result = 31 * result + (allowRatings ? 1 : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        return result;
    }
}