package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class FuelType(
    @SerializedName("description") val description: String,
    @SerializedName("isEcoFriendly") val isEcoFriendly: Boolean,
    @SerializedName("isPlugin") val isPlugin: Boolean
)