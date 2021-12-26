package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class AttributesNetwrokEntity(
    @SerializedName("identifier") val identifier: String,
    @SerializedName("displayValue") val displayValue: String
)