package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class GetSharePanelCommand : Parcelable, Serializable {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null

    @SerializedName("webPlayerShareEntityServiceEndpoint")
    var webPlayerShareEntityServiceEndpoint: WebPlayerShareEntityServiceEndpoint? = null
    override fun toString(): String {
        return "GetSharePanelCommand{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                ",webPlayerShareEntityServiceEndpoint = '" + webPlayerShareEntityServiceEndpoint + '\'' +
                "}"
    }
}