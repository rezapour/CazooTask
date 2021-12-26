package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AttributesNetwrokEntity(
    @Expose @SerializedName("identifier") val identifier: String,
    @Expose @SerializedName("displayValue") val displayValue: String
)