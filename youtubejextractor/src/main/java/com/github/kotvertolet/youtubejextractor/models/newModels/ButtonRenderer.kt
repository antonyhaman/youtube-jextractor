package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class ButtonRenderer : Parcelable, Serializable {
    @SerializedName("trackingParams")
    var trackingParams: String? = null

    @SerializedName("size")
    var size: String? = null

    @SerializedName("style")
    var style: String? = null

    @SerializedName("text")
    var text: Text? = null

    @SerializedName("serviceEndpoint")
    var serviceEndpoint: ServiceEndpoint? = null

    @SerializedName("navigationEndpoint")
    var navigationEndpoint: NavigationEndpoint? = null
    override fun toString(): String {
        return "ButtonRenderer{" +
                "trackingParams = '" + trackingParams + '\'' +
                ",size = '" + size + '\'' +
                ",style = '" + style + '\'' +
                ",text = '" + text + '\'' +
                ",serviceEndpoint = '" + serviceEndpoint + '\'' +
                ",navigationEndpoint = '" + navigationEndpoint + '\'' +
                "}"
    }
}