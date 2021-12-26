package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoordinatesNetWorkEntity(
    @Expose @SerializedName("x") val x: Double,
    @Expose @SerializedName("y") val y: Double
)