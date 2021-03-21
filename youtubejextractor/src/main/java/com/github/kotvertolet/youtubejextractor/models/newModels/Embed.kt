package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Embed : Parcelable, Serializable {
    @SerializedName("width")
    var width = 0

    @SerializedName("flashUrl")
    var flashUrl: String? = null

    @SerializedName("flashSecureUrl")
    var flashSecureUrl: String? = null

    @SerializedName("iframeUrl")
    var iframeUrl: String? = null

    @SerializedName("height")
    var height = 0
    override fun toString(): String {
        return "Embed{" +
                "width = '" + width + '\'' +
                ",flashUrl = '" + flashUrl + '\'' +
                ",flashSecureUrl = '" + flashSecureUrl + '\'' +
                ",iframeUrl = '" + iframeUrl + '\'' +
                ",height = '" + height + '\'' +
                "}"
    }
}