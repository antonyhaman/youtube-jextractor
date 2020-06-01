package com.github.kotvertolet.youtubejextractor.models.youtube.videoData;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class VideoDetails implements Parcelable, Serializable {

    public static final Creator<VideoDetails> CREATOR = new Creator<VideoDetails>() {
        @Override
        public VideoDetails createFromParcel(Parcel in) {
            return new VideoDetails(in);
        }

        @Override
        public VideoDetails[] newArray(int size) {
            return new VideoDetails[size];
        }
    };
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

    public VideoDetails() {
    }

    public VideoDetails(boolean isOwnerViewing, Thumbnail thumbnail, boolean isLiveContent,
                        List<String> keywords, String author, String lengthSeconds, String videoId,
                        String shortDescription, boolean isPrivate, String title, boolean isCrawlable,
                        double averageRating, boolean isUnpluggedCorpus, boolean allowRatings,
                        String viewCount, String channelId) {
        this.isOwnerViewing = isOwnerViewing;
        this.thumbnail = thumbnail;
        this.isLiveContent = isLiveContent;
        this.keywords = keywords;
        this.author = author;
        this.lengthSeconds = lengthSeconds;
        this.videoId = videoId;
        this.shortDescription = shortDescription;
        this.isPrivate = isPrivate;
        this.title = title;
        this.isCrawlable = isCrawlable;
        this.averageRating = averageRating;
        this.isUnpluggedCorpus = isUnpluggedCorpus;
        this.allowRatings = allowRatings;
        this.viewCount = viewCount;
        this.channelId = channelId;
    }

    protected VideoDetails(Parcel in) {
        isOwnerViewing = in.readInt() != 0;
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        isLiveContent = in.readInt() != 0;
        keywords = in.createStringArrayList();
        author = in.readString();
        lengthSeconds = in.readString();
        videoId = in.readString();
        shortDescription = in.readString();
        isPrivate = in.readInt() != 0;
        title = in.readString();
        isCrawlable = in.readInt() != 0;
        averageRating = in.readDouble();
        isUnpluggedCorpus = in.readInt() != 0;
        allowRatings = in.readInt() != 0;
        viewCount = in.readString();
        channelId = in.readString();
    }

    public boolean isIsOwnerViewing() {
        return isOwnerViewing;
    }

    public void setIsOwnerViewing(boolean isOwnerViewing) {
        this.isOwnerViewing = isOwnerViewing;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean isLiveContent() {
        return isLiveContent;
    }

    public void setIsLiveContent(boolean isLiveContent) {
        this.isLiveContent = isLiveContent;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLengthSeconds() {
        return lengthSeconds;
    }

    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsCrawlable() {
        return isCrawlable;
    }

    public void setIsCrawlable(boolean isCrawlable) {
        this.isCrawlable = isCrawlable;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }

    public void setIsUnpluggedCorpus(boolean isUnpluggedCorpus) {
        this.isUnpluggedCorpus = isUnpluggedCorpus;
    }

    public boolean isAllowRatings() {
        return allowRatings;
    }

    public void setAllowRatings(boolean allowRatings) {
        this.allowRatings = allowRatings;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(isOwnerViewing ? 1 : 0);
        dest.writeParcelable(thumbnail, flags);
        dest.writeInt(isLiveContent ? 1 : 0);
        dest.writeList(keywords);
        dest.writeString(author);
        dest.writeString(lengthSeconds);
        dest.writeString(videoId);
        dest.writeString(shortDescription);
        dest.writeInt(isPrivate ? 1 : 0);
        dest.writeString(title);
        dest.writeInt(isCrawlable ? 1 : 0);
        dest.writeDouble(averageRating);
        dest.writeInt(isUnpluggedCorpus ? 1 : 0);
        dest.writeInt(allowRatings ? 1 : 0);
        dest.writeString(viewCount);
        dest.writeString(channelId);
    }
}