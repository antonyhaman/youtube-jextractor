package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class FeaturedChannel : Parcelable, Serializable {
    @SerializedName("trackingParams")
    var trackingParams: String? = null

    @SerializedName("watermark")
    var watermark: Watermark? = null

    @SerializedName("subscribeButton")
    var subscribeButton: SubscribeButton? = null

    @SerializedName("startTimeMs")
    var startTimeMs: String? = null

    @SerializedName("channelName")
    var channelName: String? = null

    @SerializedName("endTimeMs")
    var endTimeMs: String? = null

    @SerializedName("navigationEndpoint")
    var navigationEndpoint: NavigationEndpoint? = null
    override fun toString(): String {
        return "FeaturedChannel{" +
                "trackingParams = '" + trackingParams + '\'' +
                ",watermark = '" + watermark + '\'' +
                ",subscribeButton = '" + subscribeButton + '\'' +
                ",startTimeMs = '" + startTimeMs + '\'' +
                ",channelName = '" + channelName + '\'' +
                ",endTimeMs = '" + endTimeMs + '\'' +
                ",navigationEndpoint = '" + navigationEndpoint + '\'' +
                "}"
    }
}