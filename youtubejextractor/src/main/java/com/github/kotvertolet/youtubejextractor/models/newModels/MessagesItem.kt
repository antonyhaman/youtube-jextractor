package com.github.kotvertolet.youtubejextractor.models.newModels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class MessagesItem : Parcelable, Serializable {
    @SerializedName("mealbarPromoRenderer")
    var mealbarPromoRenderer: MealbarPromoRenderer? = null
    override fun toString(): String {
        return "MessagesItem{" +
                "mealbarPromoRenderer = '" + mealbarPromoRenderer + '\'' +
                "}"
    }
}