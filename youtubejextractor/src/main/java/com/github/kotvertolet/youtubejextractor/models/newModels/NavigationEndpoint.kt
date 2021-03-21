package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class NavigationEndpoint : Parcelable, Serializable {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null

    @SerializedName("browseEndpoint")
    var browseEndpoint: BrowseEndpoint? = null
    override fun toString(): String {
        return "NavigationEndpoint{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                ",browseEndpoint = '" + browseEndpoint + '\'' +
                "}"
    }
}