package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DisplayValueNetworkEntity(
    @Expose @SerializedName("identifier") val identifier: String,
    @Expose @SerializedName("displayLabel") val displayLabel: String,
    @Expose @SerializedName("displayValue") val displayValue: String
)