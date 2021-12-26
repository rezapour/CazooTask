package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("bodyType") val bodyType: List<AttributesNetwrokEntity>,
    @SerializedName("driveType") val driveType: List<AttributesNetwrokEntity>,
    @SerializedName("colour") val colour: List<Colour>,
    @SerializedName("gearbox") val gearbox: List<AttributesNetwrokEntity>,
    @SerializedName("fuelType") val fuelType: List<AttributesNetwrokEntity>,
    @SerializedName("minMileage") val minMileage: List<AttributesX>,
    @SerializedName("maxMileage") val maxMileage: List<AttributesX>,
    @SerializedName("minPrice") val minPrice: List<AttributesX>,
    @SerializedName("maxPrice") val maxPrice: List<AttributesX>,
    @SerializedName("minMonthlyPrice") val minMonthlyPrice: List<AttributesX>,
    @SerializedName("maxMonthlyPrice") val maxMonthlyPrice: List<AttributesX>,
    @SerializedName("minSubscriptionMonthlyPrice") val minSubscriptionMonthlyPrice: List<AttributesX>,
    @SerializedName("maxSubscriptionMonthlyPrice") val maxSubscriptionMonthlyPrice: List<AttributesX>,
    @SerializedName("verifiedFeatures") val verifiedFeatures: List<AttributesNetwrokEntity>,
    @SerializedName("minManufacturedYear") val minManufacturedYear: List<AttributeValueNetworkEntity>,
    @SerializedName("maxManufacturedYear") val maxManufacturedYear: List<AttributeValueNetworkEntity>,
    @SerializedName("co2EmissionsGPerKm") val co2EmissionsGPerKm: List<AttributeValueNetworkEntity>,
    @SerializedName("runningCosts") val runningCosts: List<AttributesNetwrokEntity>,
    @SerializedName("minEngineSizeLitres") val minEngineSizeLitres: List<AttributesX>,
    @SerializedName("maxEngineSizeLitres") val maxEngineSizeLitres: List<AttributesX>,
    @SerializedName("numDoors") val numDoors: List<AttributesNetwrokEntity>,
    @SerializedName("numSeats") val numSeats: List<AttributesNetwrokEntity>,
    @SerializedName("ownershipType") val ownershipType: List<AttributesNetwrokEntity>,
    @SerializedName("combinedConsumptionMpg") val combinedConsumptionMpg: List<AttributesX>,
    @SerializedName("financeDeposit") val financeDeposit: List<AttributesX>,
    @SerializedName("financeLengthOfTerm") val financeLengthOfTerm: List<AttributeValueNetworkEntity>,
    @SerializedName("make") val make: List<AttributesNetwrokEntity>
)