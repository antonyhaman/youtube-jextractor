package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class SubscribeCommand {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("subscribeEndpoint")
    var subscribeEndpoint: SubscribeEndpoint? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null
    override fun toString(): String {
        return "SubscribeCommand{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",subscribeEndpoint = '" + subscribeEndpoint + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                "}"
    }
}