package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Accessibility : Parcelable, Serializable {
    @SerializedName("label")
    var label: String? = null
    override fun toString(): String {
        return "Accessibility{" +
                "label = '" + label + '\'' +
                "}"
    }
}