package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class MiniplayerRenderer : Parcelable, Serializable {
    @SerializedName("playbackMode")
    var playbackMode: String? = null
    override fun toString(): String {
        return "MiniplayerRenderer{" +
                "playbackMode = '" + playbackMode + '\'' +
                "}"
    }
}