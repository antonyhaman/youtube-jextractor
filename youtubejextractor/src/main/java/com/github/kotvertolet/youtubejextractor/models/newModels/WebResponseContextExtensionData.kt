package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class WebResponseContextExtensionData : Parcelable, Serializable {
    @SerializedName("hasDecorated")
    var isHasDecorated = false
    override fun toString(): String {
        return "WebResponseContextExtensionData{" +
                "hasDecorated = '" + isHasDecorated + '\'' +
                "}"
    }
}