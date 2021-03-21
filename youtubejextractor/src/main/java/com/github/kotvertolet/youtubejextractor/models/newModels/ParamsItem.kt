package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class ParamsItem : Parcelable, Serializable {
    @SerializedName("value")
    var value: String? = null

    @SerializedName("key")
    var key: String? = null
    override fun toString(): String {
        return "ParamsItem{" +
                "value = '" + value + '\'' +
                ",key = '" + key + '\'' +
                "}"
    }
}