package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class Pricing(
    @SerializedName("fullPrice") val fullPrice: PriceModelNetworkEntity,
    @SerializedName("pcmPrice") val pcmPrice: PcmPrice
)