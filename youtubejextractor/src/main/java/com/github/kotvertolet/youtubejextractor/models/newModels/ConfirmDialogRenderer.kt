package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class ConfirmDialogRenderer : Parcelable, Serializable {
    @SerializedName("trackingParams")
    var trackingParams: String? = null

    @SerializedName("cancelButton")
    var cancelButton: CancelButton? = null

    @SerializedName("confirmButton")
    var confirmButton: ConfirmButton? = null

    @SerializedName("dialogMessages")
    var dialogMessages: List<DialogMessagesItem>? = null

    @SerializedName("primaryIsCancel")
    var isPrimaryIsCancel = false
    override fun toString(): String {
        return "ConfirmDialogRenderer{" +
                "trackingParams = '" + trackingParams + '\'' +
                ",cancelButton = '" + cancelButton + '\'' +
                ",confirmButton = '" + confirmButton + '\'' +
                ",dialogMessages = '" + dialogMessages + '\'' +
                ",primaryIsCancel = '" + isPrimaryIsCancel + '\'' +
                "}"
    }
}