package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlaylistEditEndpoint : Parcelable, Serializable {
    @SerializedName("playlistId")
    var playlistId: String? = null

    @SerializedName("actions")
    var actions: List<ActionsItem>? = null
    override fun toString(): String {
        return "PlaylistEditEndpoint{" +
                "playlistId = '" + playlistId + '\'' +
                ",actions = '" + actions + '\'' +
                "}"
    }
}