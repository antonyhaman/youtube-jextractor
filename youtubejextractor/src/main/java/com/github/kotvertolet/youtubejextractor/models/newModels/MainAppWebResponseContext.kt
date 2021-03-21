package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class MainAppWebResponseContext : Parcelable, Serializable {
    @SerializedName("loggedOut")
    var isLoggedOut = false
    override fun toString(): String {
        return "MainAppWebResponseContext{" +
                "loggedOut = '" + isLoggedOut + '\'' +
                "}"
    }
}