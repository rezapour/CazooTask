package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MotHistoryNetworkEntity(

    @Expose @SerializedName("testDate") val testDate: String,
    @Expose @SerializedName("expiryDate") val expiryDate: String,
    @Expose @SerializedName("hasPassed") val hasPassed: Boolean,
    @Expose @SerializedName("mileage") val mileage: Long
)


