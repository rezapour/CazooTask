package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class AttributesX(
    @SerializedName("value") val value: Int,
    @SerializedName("displayValue") val displayValue: String,
    @SerializedName("unit") val unit: String,
    @SerializedName("formattedDisplayValue") val formattedDisplayValue: String
)