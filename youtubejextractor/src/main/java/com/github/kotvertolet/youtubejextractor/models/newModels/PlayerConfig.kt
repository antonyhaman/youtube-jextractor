package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlayerConfig : Parcelable, Serializable {
    @SerializedName("webPlayerConfig")
    var webPlayerConfig: WebPlayerConfig? = null

    @SerializedName("mediaCommonConfig")
    var mediaCommonConfig: MediaCommonConfig? = null

    @SerializedName("daiConfig")
    var daiConfig: DaiConfig? = null

    @SerializedName("audioConfig")
    var audioConfig: AudioConfig? = null

    @SerializedName("streamSelectionConfig")
    var streamSelectionConfig: StreamSelectionConfig? = null
    override fun toString(): String {
        return "PlayerConfig{" +
                "webPlayerConfig = '" + webPlayerConfig + '\'' +
                ",mediaCommonConfig = '" + mediaCommonConfig + '\'' +
                ",daiConfig = '" + daiConfig + '\'' +
                ",audioConfig = '" + audioConfig + '\'' +
                ",streamSelectionConfig = '" + streamSelectionConfig + '\'' +
                "}"
    }
}