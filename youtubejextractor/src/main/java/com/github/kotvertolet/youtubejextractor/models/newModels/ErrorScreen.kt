package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ErrorScreen : Parcelable {
    @SerializedName("playabilityStatus")
    var playabilityStatus: PlayabilityStatus? = null

    @SerializedName("playerErrorMessageRenderer")
    var playerErrorMessageRenderer: PlayerErrorMessageRenderer? = null
    override fun toString(): String {
        return "ErrorScreen{" +
                "playabilityStatus = '" + playabilityStatus + '\'' +
                ",playerErrorMessageRenderer = '" + playerErrorMessageRenderer + '\'' +
                "}"
    }
}