package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class WebPlayerConfig : Parcelable, Serializable {
    @SerializedName("webPlayerActionsPorting")
    var webPlayerActionsPorting: WebPlayerActionsPorting? = null
    override fun toString(): String {
        return "WebPlayerConfig{" +
                "webPlayerActionsPorting = '" + webPlayerActionsPorting + '\'' +
                "}"
    }
}