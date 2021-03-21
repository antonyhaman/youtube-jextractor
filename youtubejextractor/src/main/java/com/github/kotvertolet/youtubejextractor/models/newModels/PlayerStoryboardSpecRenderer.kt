package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlayerStoryboardSpecRenderer : Parcelable, Serializable {
    @SerializedName("spec")
    var spec: String? = null
    override fun toString(): String {
        return "PlayerStoryboardSpecRenderer{" +
                "spec = '" + spec + '\'' +
                "}"
    }
}