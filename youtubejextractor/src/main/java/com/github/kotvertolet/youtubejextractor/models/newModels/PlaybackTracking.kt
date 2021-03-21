package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class PlaybackTracking : Parcelable, Serializable {
    @SerializedName("videostatsWatchtimeUrl")
    var videostatsWatchtimeUrl: VideostatsWatchtimeUrl? = null

    @SerializedName("videostatsDelayplayUrl")
    var videostatsDelayplayUrl: VideostatsDelayplayUrl? = null

    @SerializedName("qoeUrl")
    var qoeUrl: QoeUrl? = null

    @SerializedName("youtubeRemarketingUrl")
    var youtubeRemarketingUrl: YoutubeRemarketingUrl? = null

    @SerializedName("googleRemarketingUrl")
    var googleRemarketingUrl: GoogleRemarketingUrl? = null

    @SerializedName("setAwesomeUrl")
    var setAwesomeUrl: SetAwesomeUrl? = null

    @SerializedName("videostatsPlaybackUrl")
    var videostatsPlaybackUrl: VideostatsPlaybackUrl? = null

    @SerializedName("ptrackingUrl")
    var ptrackingUrl: PtrackingUrl? = null

    @SerializedName("atrUrl")
    var atrUrl: AtrUrl? = null
    override fun toString(): String {
        return "PlaybackTracking{" +
                "videostatsWatchtimeUrl = '" + videostatsWatchtimeUrl + '\'' +
                ",videostatsDelayplayUrl = '" + videostatsDelayplayUrl + '\'' +
                ",qoeUrl = '" + qoeUrl + '\'' +
                ",youtubeRemarketingUrl = '" + youtubeRemarketingUrl + '\'' +
                ",googleRemarketingUrl = '" + googleRemarketingUrl + '\'' +
                ",setAwesomeUrl = '" + setAwesomeUrl + '\'' +
                ",videostatsPlaybackUrl = '" + videostatsPlaybackUrl + '\'' +
                ",ptrackingUrl = '" + ptrackingUrl + '\'' +
                ",atrUrl = '" + atrUrl + '\'' +
                "}"
    }
}