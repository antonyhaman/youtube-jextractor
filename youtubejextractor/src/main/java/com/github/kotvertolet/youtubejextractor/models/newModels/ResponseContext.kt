package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class ResponseContext {
    @SerializedName("serviceTrackingParams")
    var serviceTrackingParams: List<ServiceTrackingParamsItem>? = null

    @SerializedName("webResponseContextExtensionData")
    var webResponseContextExtensionData: WebResponseContextExtensionData? = null

    @SerializedName("mainAppWebResponseContext")
    var mainAppWebResponseContext: MainAppWebResponseContext? = null
    override fun toString(): String {
        return "ResponseContext{" +
                "serviceTrackingParams = '" + serviceTrackingParams + '\'' +
                ",webResponseContextExtensionData = '" + webResponseContextExtensionData + '\'' +
                ",mainAppWebResponseContext = '" + mainAppWebResponseContext + '\'' +
                "}"
    }
}