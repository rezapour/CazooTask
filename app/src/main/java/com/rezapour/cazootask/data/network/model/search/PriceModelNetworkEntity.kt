package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class PriceModelNetworkEntity(
    @SerializedName("centAmount") val centAmount: Int,
    @SerializedName("currencyCode") val currencyCode: String,
    @SerializedName("value") val value: Int,
    @SerializedName("type") val type: String?
)