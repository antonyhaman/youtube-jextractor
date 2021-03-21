package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class UnsubscribeEndpoint : Parcelable, Serializable {
    @SerializedName("channelIds")
    var channelIds: List<String>? = null

    @SerializedName("params")
    var params: String? = null
    override fun toString(): String {
        return "UnsubscribeEndpoint{" +
                "channelIds = '" + channelIds + '\'' +
                ",params = '" + params + '\'' +
                "}"
    }
}