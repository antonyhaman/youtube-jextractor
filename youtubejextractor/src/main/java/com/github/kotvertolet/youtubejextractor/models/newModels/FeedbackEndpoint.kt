package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class FeedbackEndpoint : Parcelable, Serializable {
    @SerializedName("uiActions")
    var uiActions: UiActions? = null

    @SerializedName("feedbackToken")
    var feedbackToken: String? = null
    override fun toString(): String {
        return "FeedbackEndpoint{" +
                "uiActions = '" + uiActions + '\'' +
                ",feedbackToken = '" + feedbackToken + '\'' +
                "}"
    }
}