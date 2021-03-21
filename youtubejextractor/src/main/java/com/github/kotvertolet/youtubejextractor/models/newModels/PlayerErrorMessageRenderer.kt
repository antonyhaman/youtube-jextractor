package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlayerErrorMessageRenderer : Parcelable  {
    @SerializedName("reason")
    var reason: Reason? = null

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    @SerializedName("icon")
    var icon: Icon? = null

    @SerializedName("subreason")
    var subreason: Subreason? = null
    override fun toString(): String {
        return "PlayerErrorMessageRenderer{" +
                "reason = '" + reason + '\'' +
                ",thumbnail = '" + thumbnail + '\'' +
                ",icon = '" + icon + '\'' +
                ",subreason = '" + subreason + '\'' +
                "}"
    }
}