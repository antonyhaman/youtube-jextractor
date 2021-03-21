package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class UnsubscribeCommand {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null

    @SerializedName("unsubscribeEndpoint")
    var unsubscribeEndpoint: UnsubscribeEndpoint? = null
    override fun toString(): String {
        return "UnsubscribeCommand{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                ",unsubscribeEndpoint = '" + unsubscribeEndpoint + '\'' +
                "}"
    }
}