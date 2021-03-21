package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Icon : Parcelable {
    @SerializedName("iconType")
    var iconType: String? = null
    override fun toString(): String {
        return "Icon{" +
                "iconType = '" + iconType + '\'' +
                "}"
    }
}