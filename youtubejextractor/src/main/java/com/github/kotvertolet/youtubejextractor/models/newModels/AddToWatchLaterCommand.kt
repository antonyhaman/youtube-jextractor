package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class AddToWatchLaterCommand : Parcelable, Serializable {
    @SerializedName("commandMetadata")
    var commandMetadata: CommandMetadata? = null

    @SerializedName("playlistEditEndpoint")
    var playlistEditEndpoint: PlaylistEditEndpoint? = null

    @SerializedName("clickTrackingParams")
    var clickTrackingParams: String? = null
    override fun toString(): String {
        return "AddToWatchLaterCommand{" +
                "commandMetadata = '" + commandMetadata + '\'' +
                ",playlistEditEndpoint = '" + playlistEditEndpoint + '\'' +
                ",clickTrackingParams = '" + clickTrackingParams + '\'' +
                "}"
    }
}