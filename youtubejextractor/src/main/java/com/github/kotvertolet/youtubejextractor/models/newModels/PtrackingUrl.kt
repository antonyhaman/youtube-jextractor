package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PtrackingUrl : Parcelable, Serializable {
    @SerializedName("baseUrl")
    var baseUrl: String? = null
    override fun toString(): String {
        return "PtrackingUrl{" +
                "baseUrl = '" + baseUrl + '\'' +
                "}"
    }
}