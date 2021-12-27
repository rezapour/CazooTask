package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RunningCostsNetWorkEntity(
    @Expose @SerializedName("insuranceGroup") val insuranceGroup: Int,
    @Expose @SerializedName("insuranceCostPerYear") val insuranceCostPerYear: CostNetWorkEntity,
    @Expose @SerializedName("fuelConsumptionMpg") val fuelConsumptionMpg: Double,
    @Expose @SerializedName("fuelConsumptionCostPerWeek") val fuelConsumptionCostPerWeek: CostNetWorkEntity

    )