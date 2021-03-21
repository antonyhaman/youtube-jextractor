package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class VideoDetails : Parcelable, Serializable {
    @SerializedName("isOwnerViewing")
    var isIsOwnerViewing = false
        private set

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    @SerializedName("isLiveContent")
    var isLiveContent = false

    @SerializedName("keywords")
    var keywords: List<String>? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("lengthSeconds")
    var lengthSeconds: String? = null

    @SerializedName("videoId")
    var videoId: String? = null

    @SerializedName("shortDescription")
    var shortDescription: String? = null

    @SerializedName("isPrivate")
    var isIsPrivate = false
        private set

    @SerializedName("title")
    var title: String? = null

    @SerializedName("isCrawlable")
    var isIsCrawlable = false
        private set

    @SerializedName("averageRating")
    var averageRating = 0.0

    @SerializedName("isUnpluggedCorpus")
    var isIsUnpluggedCorpus = false
        private set

    @SerializedName("allowRatings")
    var isAllowRatings = false

    @SerializedName("viewCount")
    var viewCount: String? = null

    @SerializedName("channelId")
    var channelId: String? = null
    fun setIsOwnerViewing(isOwnerViewing: Boolean) {
        isIsOwnerViewing = isOwnerViewing
    }

    fun setIsPrivate(isPrivate: Boolean) {
        isIsPrivate = isPrivate
    }

    fun setIsCrawlable(isCrawlable: Boolean) {
        isIsCrawlable = isCrawlable
    }

    fun setIsUnpluggedCorpus(isUnpluggedCorpus: Boolean) {
        isIsUnpluggedCorpus = isUnpluggedCorpus
    }

    override fun toString(): String {
        return "VideoDetails{" +
                "isOwnerViewing = '" + isIsOwnerViewing + '\'' +
                ",thumbnail = '" + thumbnail + '\'' +
                ",isLiveContent = '" + isLiveContent + '\'' +
                ",keywords = '" + keywords + '\'' +
                ",author = '" + author + '\'' +
                ",lengthSeconds = '" + lengthSeconds + '\'' +
                ",videoId = '" + videoId + '\'' +
                ",shortDescription = '" + shortDescription + '\'' +
                ",isPrivate = '" + isIsPrivate + '\'' +
                ",title = '" + title + '\'' +
                ",isCrawlable = '" + isIsCrawlable + '\'' +
                ",averageRating = '" + averageRating + '\'' +
                ",isUnpluggedCorpus = '" + isIsUnpluggedCorpus + '\'' +
                ",allowRatings = '" + isAllowRatings + '\'' +
                ",viewCount = '" + viewCount + '\'' +
                ",channelId = '" + channelId + '\'' +
                "}"
    }
}