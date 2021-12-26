package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class PcmPrice(
    @SerializedName("pcp") val pcp: PriceModelNetworkEntity,
    @SerializedName("hp") val hp: PriceModelNetworkEntity,
    @SerializedName("lowest") val lowest: PriceModelNetworkEntity
)