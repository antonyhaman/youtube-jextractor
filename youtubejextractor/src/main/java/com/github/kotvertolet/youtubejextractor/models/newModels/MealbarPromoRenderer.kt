package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class MealbarPromoRenderer : Parcelable, Serializable {
    @SerializedName("triggerCondition")
    var triggerCondition: String? = null

    @SerializedName("trackingParams")
    var trackingParams: String? = null

    @SerializedName("impressionEndpoints")
    var impressionEndpoints: List<ImpressionEndpointsItem>? = null

    @SerializedName("dismissButton")
    var dismissButton: DismissButton? = null

    @SerializedName("icon")
    var icon: Icon? = null

    @SerializedName("actionButton")
    var actionButton: ActionButton? = null

    @SerializedName("messageTexts")
    var messageTexts: List<MessageTextsItem>? = null

    @SerializedName("messageTitle")
    var messageTitle: MessageTitle? = null

    @SerializedName("style")
    var style: String? = null

    @SerializedName("isVisible")
    var isIsVisible = false
        private set

    fun setIsVisible(isVisible: Boolean) {
        isIsVisible = isVisible
    }

    override fun toString(): String {
        return "MealbarPromoRenderer{" +
                "triggerCondition = '" + triggerCondition + '\'' +
                ",trackingParams = '" + trackingParams + '\'' +
                ",impressionEndpoints = '" + impressionEndpoints + '\'' +
                ",dismissButton = '" + dismissButton + '\'' +
                ",icon = '" + icon + '\'' +
                ",actionButton = '" + actionButton + '\'' +
                ",messageTexts = '" + messageTexts + '\'' +
                ",messageTitle = '" + messageTitle + '\'' +
                ",style = '" + style + '\'' +
                ",isVisible = '" + isIsVisible + '\'' +
                "}"
    }
}