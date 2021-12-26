package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class OdometerReading(
    @SerializedName("unit") val unit: String,
    @SerializedName("value") val value: Int
)