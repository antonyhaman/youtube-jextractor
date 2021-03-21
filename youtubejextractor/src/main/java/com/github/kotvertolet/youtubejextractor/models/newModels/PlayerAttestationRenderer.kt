package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlayerAttestationRenderer : Parcelable, Serializable {
    @SerializedName("botguardData")
    var botguardData: BotguardData? = null

    @SerializedName("challenge")
    var challenge: String? = null
    override fun toString(): String {
        return "PlayerAttestationRenderer{" +
                "botguardData = '" + botguardData + '\'' +
                ",challenge = '" + challenge + '\'' +
                "}"
    }
}