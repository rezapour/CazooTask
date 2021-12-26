package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OdometerReading(
    @Expose @SerializedName("unit") val unit: String,
    @Expose @SerializedName("value") val value: Int
)