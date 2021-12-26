package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rezapour.cazootask.data.network.model.search.OdometerReading

data class ServiceHistoryNetworkEntity(
    @Expose @SerializedName("franchiseType") val franchiseType: String,
    @Expose @SerializedName("franchiseName") val franchiseName: String,
    @Expose @SerializedName("town") val town: String,
    @Expose @SerializedName("source") val source :String ,
    @Expose @SerializedName("date") val date:String,
    @Expose @SerializedName("odometer") val odometer:OdometerReading,
)
