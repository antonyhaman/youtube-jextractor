package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlayerAnnotationsExpandedRenderer : Parcelable, Serializable {
    @SerializedName("featuredChannel")
    var featuredChannel: FeaturedChannel? = null

    @SerializedName("annotationId")
    var annotationId: String? = null

    @SerializedName("allowSwipeDismiss")
    var isAllowSwipeDismiss = false
    override fun toString(): String {
        return "PlayerAnnotationsExpandedRenderer{" +
                "featuredChannel = '" + featuredChannel + '\'' +
                ",annotationId = '" + annotationId + '\'' +
                ",allowSwipeDismiss = '" + isAllowSwipeDismiss + '\'' +
                "}"
    }
}