package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class ServiceEndpoint {
    @SerializedName("feedbackEndpoint")
    var feedbackEndpoint: FeedbackEndpoint? = null

    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null
    override fun toString(): String {
        return "ServiceEndpoint{" +
                "feedbackEndpoint = '" + feedbackEndpoint + '\'' +
                ",commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                "}"
    }
}