package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class ServiceEndpointsItem {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null

    @SerializedName("signalServiceEndpoint")
    var signalServiceEndpoint: SignalServiceEndpoint? = null

    @SerializedName("subscribeEndpoint")
    var subscribeEndpoint: SubscribeEndpoint? = null
    override fun toString(): String {
        return "ServiceEndpointsItem{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                ",signalServiceEndpoint = '" + signalServiceEndpoint + '\'' +
                ",subscribeEndpoint = '" + subscribeEndpoint + '\'' +
                "}"
    }
}