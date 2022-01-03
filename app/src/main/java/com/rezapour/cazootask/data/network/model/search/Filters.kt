package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Filters(
    @Expose @SerializedName("bodyType") val bodyType: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("driveType") val driveType: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("colour") val colour: List<Colour>,
    @Expose @SerializedName("gearbox") val gearbox: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("fuelType") val fuelType: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("minMileage") val minMileage: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("maxMileage") val maxMileage: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("minPrice") val minPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("maxPrice") val maxPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("minMonthlyPrice") val minMonthlyPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("maxMonthlyPrice") val maxMonthlyPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("minSubscriptionMonthlyPrice") val minSubscriptionMonthlyPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("maxSubscriptionMonthlyPrice") val maxSubscriptionMonthlyPrice: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("verifiedFeatures") val verifiedFeatures: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("minManufacturedYear") val minManufacturedYear: List<AttributeValueNetworkEntity>,
    @Expose @SerializedName("maxManufacturedYear") val maxManufacturedYear: List<AttributeValueNetworkEntity>,
    @Expose @SerializedName("co2EmissionsGPerKm") val co2EmissionsGPerKm: List<AttributeValueNetworkEntity>,
    @Expose @SerializedName("runningCosts") val runningCosts: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("minEngineSizeLitres") val minEngineSizeLitres: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("maxEngineSizeLitres") val maxEngineSizeLitres: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("numDoors") val numDoors: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("numSeats") val numSeats: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("ownershipType") val ownershipType: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("combinedConsumptionMpg") val combinedConsumptionMpg: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("financeDeposit") val financeDeposit: List<AttributesDataNetwrokEntity>,
    @Expose @SerializedName("financeLengthOfTerm") val financeLengthOfTerm: List<AttributeValueNetworkEntity>,
    @Expose @SerializedName("make") val make: List<AttributesNetwrokEntity>
)