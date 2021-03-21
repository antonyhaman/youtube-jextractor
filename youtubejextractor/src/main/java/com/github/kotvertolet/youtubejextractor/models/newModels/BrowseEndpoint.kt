package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class BrowseEndpoint : Parcelable, Serializable {
    @SerializedName("browseId")
    var browseId: String? = null

    @SerializedName("params")
    var params: String? = null
    override fun toString(): String {
        return "BrowseEndpoint{" +
                "browseId = '" + browseId + '\'' +
                ",params = '" + params + '\'' +
                "}"
    }
}