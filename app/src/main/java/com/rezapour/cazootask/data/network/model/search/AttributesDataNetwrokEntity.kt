package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


data class AttributesDataNetwrokEntity(
     @Expose @SerializedName("value") val value: Double,
     @Expose @SerializedName("displayValue") val displayValue: String,
     @Expose @SerializedName("unit") val unit: String,
     @Expose @SerializedName("formattedDisplayValue") val formattedDisplayValue: String
)