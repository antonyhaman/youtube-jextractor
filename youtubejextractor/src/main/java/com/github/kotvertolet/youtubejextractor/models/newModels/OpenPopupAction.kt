package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class OpenPopupAction : Parcelable, Serializable {
    @SerializedName("popupType")
    var popupType: String? = null

    @SerializedName("popup")
    var popup: Popup? = null
    override fun toString(): String {
        return "OpenPopupAction{" +
                "popupType = '" + popupType + '\'' +
                ",popup = '" + popup + '\'' +
                "}"
    }
}