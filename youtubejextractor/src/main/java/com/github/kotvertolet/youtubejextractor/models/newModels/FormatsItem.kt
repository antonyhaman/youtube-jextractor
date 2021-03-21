package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class FormatsItem : Parcelable, Serializable {
    @SerializedName("itag")
    var itag = 0

    @SerializedName("fps")
    var fps = 0

    @SerializedName("projectionType")
    var projectionType: String? = null

    @SerializedName("bitrate")
    var bitrate = 0

    @SerializedName("mimeType")
    var mimeType: String? = null

    @SerializedName("audioQuality")
    var audioQuality: String? = null

    @SerializedName("approxDurationMs")
    var approxDurationMs: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("audioSampleRate")
    var audioSampleRate: String? = null

    @SerializedName("quality")
    var quality: String? = null

    @SerializedName("qualityLabel")
    var qualityLabel: String? = null

    @SerializedName("audioChannels")
    var audioChannels = 0

    @SerializedName("width")
    var width = 0

    @SerializedName("lastModified")
    var lastModified: String? = null

    @SerializedName("height")
    var height = 0

    @SerializedName("contentLength")
    var contentLength: String? = null

    @SerializedName("averageBitrate")
    var averageBitrate = 0
    override fun toString(): String {
        return "FormatsItem{" +
                "itag = '" + itag + '\'' +
                ",fps = '" + fps + '\'' +
                ",projectionType = '" + projectionType + '\'' +
                ",bitrate = '" + bitrate + '\'' +
                ",mimeType = '" + mimeType + '\'' +
                ",audioQuality = '" + audioQuality + '\'' +
                ",approxDurationMs = '" + approxDurationMs + '\'' +
                ",url = '" + url + '\'' +
                ",audioSampleRate = '" + audioSampleRate + '\'' +
                ",quality = '" + quality + '\'' +
                ",qualityLabel = '" + qualityLabel + '\'' +
                ",audioChannels = '" + audioChannels + '\'' +
                ",width = '" + width + '\'' +
                ",lastModified = '" + lastModified + '\'' +
                ",height = '" + height + '\'' +
                ",contentLength = '" + contentLength + '\'' +
                ",averageBitrate = '" + averageBitrate + '\'' +
                "}"
    }
}