package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Colour(
    @Expose @SerializedName("identifier") val identifier: String,
    @Expose @SerializedName("displayValue") val displayValue: String,
    @Expose @SerializedName("background") val background: String
)