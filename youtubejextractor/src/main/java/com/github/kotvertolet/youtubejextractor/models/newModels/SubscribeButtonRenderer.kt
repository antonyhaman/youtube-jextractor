package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class SubscribeButtonRenderer {
    @SerializedName("buttonText")
    var buttonText: ButtonText? = null

    @SerializedName("subscribeAccessibility")
    var subscribeAccessibility: SubscribeAccessibility? = null

    @SerializedName("showPreferences")
    var isShowPreferences = false

    @SerializedName("type")
    var type: String? = null

    @SerializedName("subscribedButtonText")
    var subscribedButtonText: SubscribedButtonText? = null

    @SerializedName("enabled")
    var isEnabled = false

    @SerializedName("unsubscribeButtonText")
    var unsubscribeButtonText: UnsubscribeButtonText? = null

    @SerializedName("signInEndpoint")
    var signInEndpoint: SignInEndpoint? = null

    @SerializedName("subscribed")
    var isSubscribed = false

    @SerializedName("unsubscribeAccessibility")
    var unsubscribeAccessibility: UnsubscribeAccessibility? = null

    @SerializedName("trackingParams")
    var trackingParams: String? = null

    @SerializedName("channelId")
    var channelId: String? = null

    @SerializedName("unsubscribedButtonText")
    var unsubscribedButtonText: UnsubscribedButtonText? = null

    @SerializedName("serviceEndpoints")
    var serviceEndpoints: List<ServiceEndpointsItem>? = null
    override fun toString(): String {
        return "SubscribeButtonRenderer{" +
                "buttonText = '" + buttonText + '\'' +
                ",subscribeAccessibility = '" + subscribeAccessibility + '\'' +
                ",showPreferences = '" + isShowPreferences + '\'' +
                ",type = '" + type + '\'' +
                ",subscribedButtonText = '" + subscribedButtonText + '\'' +
                ",enabled = '" + isEnabled + '\'' +
                ",unsubscribeButtonText = '" + unsubscribeButtonText + '\'' +
                ",signInEndpoint = '" + signInEndpoint + '\'' +
                ",subscribed = '" + isSubscribed + '\'' +
                ",unsubscribeAccessibility = '" + unsubscribeAccessibility + '\'' +
                ",trackingParams = '" + trackingParams + '\'' +
                ",channelId = '" + channelId + '\'' +
                ",unsubscribedButtonText = '" + unsubscribedButtonText + '\'' +
                ",serviceEndpoints = '" + serviceEndpoints + '\'' +
                "}"
    }
}