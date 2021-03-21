package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Attestation : Parcelable, Serializable {
    @SerializedName("playerAttestationRenderer")
    var playerAttestationRenderer: PlayerAttestationRenderer? = null
    override fun toString(): String {
        return "Attestation{" +
                "playerAttestationRenderer = '" + playerAttestationRenderer + '\'' +
                "}"
    }
}