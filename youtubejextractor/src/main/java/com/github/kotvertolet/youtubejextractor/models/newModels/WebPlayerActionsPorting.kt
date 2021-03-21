package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class WebPlayerActionsPorting : Parcelable, Serializable {
    @SerializedName("removeFromWatchLaterCommand")
    var removeFromWatchLaterCommand: RemoveFromWatchLaterCommand? = null

    @SerializedName("subscribeCommand")
    var subscribeCommand: SubscribeCommand? = null

    @SerializedName("getSharePanelCommand")
    var getSharePanelCommand: GetSharePanelCommand? = null

    @SerializedName("unsubscribeCommand")
    var unsubscribeCommand: UnsubscribeCommand? = null

    @SerializedName("addToWatchLaterCommand")
    var addToWatchLaterCommand: AddToWatchLaterCommand? = null
    override fun toString(): String {
        return "WebPlayerActionsPorting{" +
                "removeFromWatchLaterCommand = '" + removeFromWatchLaterCommand + '\'' +
                ",subscribeCommand = '" + subscribeCommand + '\'' +
                ",getSharePanelCommand = '" + getSharePanelCommand + '\'' +
                ",unsubscribeCommand = '" + unsubscribeCommand + '\'' +
                ",addToWatchLaterCommand = '" + addToWatchLaterCommand + '\'' +
                "}"
    }
}