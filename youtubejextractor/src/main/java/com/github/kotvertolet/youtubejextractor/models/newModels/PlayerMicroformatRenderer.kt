package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlayerMicroformatRenderer : Parcelable, Serializable {
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    @SerializedName("externalChannelId")
    var externalChannelId: String? = null

    @SerializedName("publishDate")
    var publishDate: String? = null

    @SerializedName("description")
    var description: Description? = null

    @SerializedName("lengthSeconds")
    var lengthSeconds: String? = null

    @SerializedName("title")
    var title: Title? = null

    @SerializedName("hasYpcMetadata")
    var isHasYpcMetadata = false

    @SerializedName("ownerChannelName")
    var ownerChannelName: String? = null

    @SerializedName("uploadDate")
    var uploadDate: String? = null

    @SerializedName("ownerProfileUrl")
    var ownerProfileUrl: String? = null

    @SerializedName("isUnlisted")
    var isIsUnlisted = false
        private set

    @SerializedName("embed")
    var embed: Embed? = null

    @SerializedName("viewCount")
    var viewCount: String? = null

    @SerializedName("category")
    var category: String? = null

    @SerializedName("isFamilySafe")
    var isIsFamilySafe = false
        private set

    @SerializedName("availableCountries")
    var availableCountries: List<String>? = null
    fun setIsUnlisted(isUnlisted: Boolean) {
        isIsUnlisted = isUnlisted
    }

    fun setIsFamilySafe(isFamilySafe: Boolean) {
        isIsFamilySafe = isFamilySafe
    }

    override fun toString(): String {
        return "PlayerMicroformatRenderer{" +
                "thumbnail = '" + thumbnail + '\'' +
                ",externalChannelId = '" + externalChannelId + '\'' +
                ",publishDate = '" + publishDate + '\'' +
                ",description = '" + description + '\'' +
                ",lengthSeconds = '" + lengthSeconds + '\'' +
                ",title = '" + title + '\'' +
                ",hasYpcMetadata = '" + isHasYpcMetadata + '\'' +
                ",ownerChannelName = '" + ownerChannelName + '\'' +
                ",uploadDate = '" + uploadDate + '\'' +
                ",ownerProfileUrl = '" + ownerProfileUrl + '\'' +
                ",isUnlisted = '" + isIsUnlisted + '\'' +
                ",embed = '" + embed + '\'' +
                ",viewCount = '" + viewCount + '\'' +
                ",category = '" + category + '\'' +
                ",isFamilySafe = '" + isIsFamilySafe + '\'' +
                ",availableCountries = '" + availableCountries + '\'' +
                "}"
    }
}