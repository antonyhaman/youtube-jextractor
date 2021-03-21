package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class AudioConfig : Parcelable, Serializable {
    @SerializedName("perceptualLoudnessDb")
    var perceptualLoudnessDb = 0.0

    @SerializedName("loudnessDb")
    var loudnessDb = 0.0

    @SerializedName("enablePerFormatLoudness")
    var isEnablePerFormatLoudness = false
    override fun toString(): String {
        return "AudioConfig{" +
                "perceptualLoudnessDb = '" + perceptualLoudnessDb + '\'' +
                ",loudnessDb = '" + loudnessDb + '\'' +
                ",enablePerFormatLoudness = '" + isEnablePerFormatLoudness + '\'' +
                "}"
    }
}