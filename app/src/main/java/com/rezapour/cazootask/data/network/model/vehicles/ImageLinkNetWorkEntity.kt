package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageLinkNetWorkEntity(
    @Expose @SerializedName("small") val small: String,
    @Expose @SerializedName("medium") val medium: String,
    @Expose @SerializedName("large") val large: String
)
