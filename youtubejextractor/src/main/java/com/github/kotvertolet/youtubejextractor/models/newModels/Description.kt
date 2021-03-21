package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Description : Parcelable, Serializable {
    @SerializedName("simpleText")
    var simpleText: String? = null
    override fun toString(): String {
        return "Description{" +
                "simpleText = '" + simpleText + '\'' +
                "}"
    }
}