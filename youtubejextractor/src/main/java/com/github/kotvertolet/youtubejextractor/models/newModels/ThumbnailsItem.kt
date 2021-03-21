package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ThumbnailsItem : Parcelable {
    @SerializedName("width")
    var width = 0

    @SerializedName("url")
    var url: String? = null

    @SerializedName("height")
    var height = 0
    override fun toString(): String {
        return "ThumbnailsItem{" +
                "width = '" + width + '\'' +
                ",url = '" + url + '\'' +
                ",height = '" + height + '\'' +
                "}"
    }
}