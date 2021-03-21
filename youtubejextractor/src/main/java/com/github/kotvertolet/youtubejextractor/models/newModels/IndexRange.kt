package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class IndexRange : Parcelable, Serializable {
    @SerializedName("start")
    var start: String? = null

    @SerializedName("end")
    var end: String? = null
    override fun toString(): String {
        return "IndexRange{" +
                "start = '" + start + '\'' +
                ",end = '" + end + '\'' +
                "}"
    }
}