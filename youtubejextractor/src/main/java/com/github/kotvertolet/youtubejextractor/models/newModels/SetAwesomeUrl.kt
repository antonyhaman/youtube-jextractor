package com.github.kotvertolet.youtubejextractor.models.newModels

import com.google.gson.annotations.SerializedName

class SetAwesomeUrl {
    @SerializedName("baseUrl")
    var baseUrl: String? = null

    @SerializedName("elapsedMediaTimeSeconds")
    var elapsedMediaTimeSeconds = 0
    override fun toString(): String {
        return "SetAwesomeUrl{" +
                "baseUrl = '" + baseUrl + '\'' +
                ",elapsedMediaTimeSeconds = '" + elapsedMediaTimeSeconds + '\'' +
                "}"
    }
}