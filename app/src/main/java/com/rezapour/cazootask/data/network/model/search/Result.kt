package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("id") val id: String,
    @SerializedName("make") val make: String,
    @SerializedName("model") val model: String,
    @SerializedName("modelYear") val modelYear: Int,
    @SerializedName("displayVariant") val displayVariant: String,
    @SerializedName("mileage") val mileage: Int,
    @SerializedName("registrationYear") val registrationYear: Int,
    @SerializedName("vrm") val vrm: String,
    @SerializedName("isForSubscription") val isForSubscription: Boolean,
    @SerializedName("isForPurchase") val isForPurchase: Boolean,
    @SerializedName("fuelType") val fuelType: FuelType,
    @SerializedName("images") val images: Images,
    @SerializedName("isPromoted") val isPromoted: Boolean,
    @SerializedName("odometerReading") val odometerReading: OdometerReading,
    @SerializedName("tradingMarket") val tradingMarket: String,
    @SerializedName("vehicleType") val vehicleType: String,
    @SerializedName("pricing") val pricing: Pricing
)