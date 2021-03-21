package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlayabilityStatus : Parcelable {
    @SerializedName("reason")
    var reason: String? = null

    @SerializedName("contextParams")
    var contextParams: String? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("errorScreen")
    var errorScreen: ErrorScreen? = null
    override fun toString(): String {
        return "PlayabilityStatus{" +
                "reason = '" + reason + '\'' +
                ",contextParams = '" + contextParams + '\'' +
                ",status = '" + status + '\'' +
                ",errorScreen = '" + errorScreen + '\'' +
                "}"
    }
}