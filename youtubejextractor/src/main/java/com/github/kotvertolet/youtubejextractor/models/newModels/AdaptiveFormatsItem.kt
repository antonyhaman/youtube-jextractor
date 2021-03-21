package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class AdaptiveFormatsItem : Parcelable, Serializable {
    @SerializedName("signatureCipher", alternate = ["cipher"])
    var cipher: Cipher? = null
    @SerializedName("itag")
    var itag = 0
    @SerializedName("indexRange")
    var indexRange: IndexRange? = null
    @SerializedName("projectionType")
    var projectionType: String? = null
    @SerializedName("initRange")
    var initRange: InitRange? = null
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
    @SerializedName("audioChannels")
    var audioChannels = 0
    @SerializedName("contentLength")
    var contentLength: String? = null
    @SerializedName("lastModified")
    var lastModified: String? = null
    @SerializedName("loudnessDb")
    var loudnessDb = 0.0
    @SerializedName("averageBitrate")
    var averageBitrate = 0
    @SerializedName("highReplication")
    var isHighReplication = false
    @SerializedName("qualityLabel")
    var qualityLabel: String? = null
    @SerializedName("width")
    var width = 0
    @SerializedName("fps")
    var fps = 0
    @SerializedName("type")
    var type: String? = null
    @SerializedName("height")
    var height = 0

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as AdaptiveFormatsItem
        if (itag != that.itag) return false
        if (bitrate != that.bitrate) return false
        if (audioChannels != that.audioChannels) return false
        if (java.lang.Double.compare(that.loudnessDb, loudnessDb) != 0) return false
        if (averageBitrate != that.averageBitrate) return false
        if (isHighReplication != that.isHighReplication) return false
        if (width != that.width) return false
        if (fps != that.fps) return false
        if (height != that.height) return false
        if (if (cipher != null) cipher != that.cipher else that.cipher != null) return false
        if (if (indexRange != null) indexRange != that.indexRange else that.indexRange != null) return false
        if (if (projectionType != null) projectionType != that.projectionType else that.projectionType != null) return false
        if (if (initRange != null) initRange != that.initRange else that.initRange != null) return false
        if (if (mimeType != null) mimeType != that.mimeType else that.mimeType != null) return false
        if (if (audioQuality != null) audioQuality != that.audioQuality else that.audioQuality != null) return false
        if (if (approxDurationMs != null) approxDurationMs != that.approxDurationMs else that.approxDurationMs != null) return false
        if (if (url != null) url != that.url else that.url != null) return false
        if (if (audioSampleRate != null) audioSampleRate != that.audioSampleRate else that.audioSampleRate != null) return false
        if (if (quality != null) quality != that.quality else that.quality != null) return false
        if (if (contentLength != null) contentLength != that.contentLength else that.contentLength != null) return false
        if (if (lastModified != null) lastModified != that.lastModified else that.lastModified != null) return false
        if (if (qualityLabel != null) qualityLabel != that.qualityLabel else that.qualityLabel != null) return false
        return if (type != null) type == that.type else that.type == null
    }

    override fun hashCode(): Int {
        var result: Int
        val temp: Long
        result = if (cipher != null) cipher.hashCode() else 0
        result = 31 * result + itag
        result = 31 * result + if (indexRange != null) indexRange.hashCode() else 0
        result = 31 * result + if (projectionType != null) projectionType.hashCode() else 0
        result = 31 * result + if (initRange != null) initRange.hashCode() else 0
        result = 31 * result + bitrate
        result = 31 * result + if (mimeType != null) mimeType.hashCode() else 0
        result = 31 * result + if (audioQuality != null) audioQuality.hashCode() else 0
        result = 31 * result + if (approxDurationMs != null) approxDurationMs.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        result = 31 * result + if (audioSampleRate != null) audioSampleRate.hashCode() else 0
        result = 31 * result + if (quality != null) quality.hashCode() else 0
        result = 31 * result + audioChannels
        result = 31 * result + if (contentLength != null) contentLength.hashCode() else 0
        result = 31 * result + if (lastModified != null) lastModified.hashCode() else 0
        temp = java.lang.Double.doubleToLongBits(loudnessDb)
        result = 31 * result + (temp xor (temp ushr 32)).toInt()
        result = 31 * result + averageBitrate
        result = 31 * result + if (isHighReplication) 1 else 0
        result = 31 * result + if (qualityLabel != null) qualityLabel.hashCode() else 0
        result = 31 * result + width
        result = 31 * result + fps
        result = 31 * result + if (type != null) type.hashCode() else 0
        result = 31 * result + height
        return result
    }
}