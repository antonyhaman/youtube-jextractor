package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Microformat : Parcelable, Serializable {
    @SerializedName("playerMicroformatRenderer")
    var playerMicroformatRenderer: PlayerMicroformatRenderer? = null
    override fun toString(): String {
        return "Microformat{" +
                "playerMicroformatRenderer = '" + playerMicroformatRenderer + '\'' +
                "}"
    }
}