package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class SubscribeEndpoint {
    @SerializedName("channelIds")
    var channelIds: List<String>? = null

    @SerializedName("params")
    var params: String? = null
    override fun toString(): String {
        return "SubscribeEndpoint{" +
                "channelIds = '" + channelIds + '\'' +
                ",params = '" + params + '\'' +
                "}"
    }
}