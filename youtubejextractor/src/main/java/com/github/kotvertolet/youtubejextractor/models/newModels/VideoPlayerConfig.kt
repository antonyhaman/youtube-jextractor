package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.StreamingData
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class VideoPlayerConfig : Parcelable, Serializable {
    @SerializedName("playerConfig")
    var playerConfig: PlayerConfig? = null

//    @SerializedName("trackingParams")
//    var trackingParams: String? = null

//    @SerializedName("attestation")
//    var attestation: Attestation? = null

    @SerializedName("videoDetails")
    var videoDetails: VideoDetails? = null

    @SerializedName("streamingData")
    var streamingData: StreamingData? = null

    @SerializedName("responseContext")
    var responseContext: ResponseContext? = null

    @SerializedName("playabilityStatus")
    var playabilityStatus: PlayabilityStatus? = null

//    @SerializedName("annotations")
//    var annotations: List<AnnotationsItem>? = null

    @SerializedName("messages")
    var messages: List<MessagesItem>? = null

    @SerializedName("playbackTracking")
    var playbackTracking: PlaybackTracking? = null

    @SerializedName("microformat")
    var microformat: Microformat? = null

//    @SerializedName("storyboards")
//    var storyboards: Storyboards? = null

    override fun toString(): String {
        return "YoutubeResponse{" +
                "playerConfig = '" + playerConfig + '\'' +
//                ",trackingParams = '" + trackingParams + '\'' +
//                ",attestation = '" + attestation + '\'' +
                ",videoDetails = '" + videoDetails + '\'' +
                ",streamingData = '" + streamingData + '\'' +
                ",responseContext = '" + responseContext + '\'' +
//                ",playabilityStatus = '" + playabilityStatus + '\'' +
//                ",annotations = '" + annotations + '\'' +
//                ",messages = '" + messages + '\'' +
                ",playbackTracking = '" + playbackTracking + '\'' +
                ",microformat = '" + microformat + '\'' +
//                ",storyboards = '" + storyboards + '\'' +
                "}"
    }
}