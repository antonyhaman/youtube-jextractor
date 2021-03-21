package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class YoutubeRemarketingUrl : Parcelable, Serializable {
    @SerializedName("baseUrl")
    var baseUrl: String? = null

    @SerializedName("elapsedMediaTimeSeconds")
    var elapsedMediaTimeSeconds = 0
    override fun toString(): String {
        return "YoutubeRemarketingUrl{" +
                "baseUrl = '" + baseUrl + '\'' +
                ",elapsedMediaTimeSeconds = '" + elapsedMediaTimeSeconds + '\'' +
                "}"
    }
}