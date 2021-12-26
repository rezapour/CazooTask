package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VehicleHistoryNetworkEntity(
    @Expose @SerializedName("registrationDate") val registrationDate: String,
    @Expose @SerializedName("numberOfPreviousKeepers") val numberOfPreviousKeepers: Int,
    @Expose @SerializedName("motHistory") val motHistory:List<MotHistoryNetworkEntity>
)