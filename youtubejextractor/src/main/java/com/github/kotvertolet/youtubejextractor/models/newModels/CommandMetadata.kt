package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class CommandMetadata : Parcelable, Serializable {
    @SerializedName("webCommandMetadata")
    var webCommandMetadata: WebCommandMetadata? = null
    override fun toString(): String {
        return "CommandMetadata{" +
                "webCommandMetadata = '" + webCommandMetadata + '\'' +
                "}"
    }
}