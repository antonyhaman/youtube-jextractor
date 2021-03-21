package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class ImpressionEndpointsItem : Parcelable, Serializable {
    @SerializedName("feedbackEndpoint")
    var feedbackEndpoint: FeedbackEndpoint? = null

    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null
    override fun toString(): String {
        return "ImpressionEndpointsItem{" +
                "feedbackEndpoint = '" + feedbackEndpoint + '\'' +
                ",commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                "}"
    }
}