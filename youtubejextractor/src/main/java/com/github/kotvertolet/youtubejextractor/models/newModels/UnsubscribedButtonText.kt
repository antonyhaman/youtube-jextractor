package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class UnsubscribedButtonText : Parcelable, Serializable {
    @SerializedName("runs")
    var runs: List<RunsItem>? = null
    override fun toString(): String {
        return "UnsubscribedButtonText{" +
                "runs = '" + runs + '\'' +
                "}"
    }
}