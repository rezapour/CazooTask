package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FuelType(
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("isEcoFriendly") val isEcoFriendly: Boolean,
    @Expose @SerializedName("isPlugin") val isPlugin: Boolean
)