package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class WebCommandMetadata : Parcelable, Serializable {
    @SerializedName("apiUrl")
    var apiUrl: String? = null

    @SerializedName("rootVe")
    var rootVe = 0

    @SerializedName("webPageType")
    var webPageType: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("sendPost")
    var isSendPost = false
    override fun toString(): String {
        return "WebCommandMetadata{" +
                "apiUrl = '" + apiUrl + '\'' +
                ",rootVe = '" + rootVe + '\'' +
                ",webPageType = '" + webPageType + '\'' +
                ",url = '" + url + '\'' +
                ",sendPost = '" + isSendPost + '\'' +
                "}"
    }
}