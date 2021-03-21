package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class DynamicReadaheadConfig : Parcelable, Serializable {
    @SerializedName("readAheadGrowthRateMs")
    var readAheadGrowthRateMs = 0

    @SerializedName("maxReadAheadMediaTimeMs")
    var maxReadAheadMediaTimeMs = 0

    @SerializedName("minReadAheadMediaTimeMs")
    var minReadAheadMediaTimeMs = 0
    override fun toString(): String {
        return "DynamicReadaheadConfig{" +
                "readAheadGrowthRateMs = '" + readAheadGrowthRateMs + '\'' +
                ",maxReadAheadMediaTimeMs = '" + maxReadAheadMediaTimeMs + '\'' +
                ",minReadAheadMediaTimeMs = '" + minReadAheadMediaTimeMs + '\'' +
                "}"
    }
}