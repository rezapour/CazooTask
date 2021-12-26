package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PriceModelNetworkEntity(
    @Expose @SerializedName("centAmount") val centAmount: Int,
    @Expose @SerializedName("currencyCode") val currencyCode: String,
    @Expose @SerializedName("value") val value: Long,
    @Expose @SerializedName("type") val type: String?
)