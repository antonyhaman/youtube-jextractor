package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class BotguardData : Parcelable, Serializable {
    @SerializedName("interpreterUrl")
    var interpreterUrl: String? = null

    @SerializedName("program")
    var program: String? = null
    override fun toString(): String {
        return "BotguardData{" +
                "interpreterUrl = '" + interpreterUrl + '\'' +
                ",program = '" + program + '\'' +
                "}"
    }
}