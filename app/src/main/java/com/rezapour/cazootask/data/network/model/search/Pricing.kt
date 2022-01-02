package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pricing(
    @Expose @SerializedName("fullPrice") val fullPrice: PriceModelNetworkEntity,
    @Expose @SerializedName("pcmPrice") val pcmPrice: PcmPrice?
)