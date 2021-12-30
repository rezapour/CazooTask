package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PcmPrice(
    @Expose @SerializedName("pcp") val pcp: PriceModelNetworkEntity?,
    @Expose @SerializedName("hp") val hp: PriceModelNetworkEntity,
    @Expose @SerializedName("lowest") val lowest: PriceModelNetworkEntity
)