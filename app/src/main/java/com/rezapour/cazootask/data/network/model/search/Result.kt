package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @Expose @SerializedName("createdAt") val createdAt: String,
    @Expose @SerializedName("id") val id: String,
    @Expose @SerializedName("make") val make: String,
    @Expose @SerializedName("model") val model: String,
    @Expose @SerializedName("modelYear") val modelYear: Int,
    @Expose @SerializedName("displayVariant") val displayVariant: String,
    @Expose @SerializedName("mileage") val mileage: Long,
    @Expose @SerializedName("registrationYear") val registrationYear: Int,
    @Expose @SerializedName("vrm") val vrm: String,
    @Expose @SerializedName("isForSubscription") val isForSubscription: Boolean,
    @Expose @SerializedName("isForPurchase") val isForPurchase: Boolean,
    @Expose @SerializedName("fuelType") val fuelType: FuelType,
    @Expose @SerializedName("images") val images: Images,
    @Expose @SerializedName("isPromoted") val isPromoted: Boolean,
    @Expose @SerializedName("odometerReading") val odometerReading: OdometerReading,
    @Expose @SerializedName("tradingMarket") val tradingMarket: String,
    @Expose @SerializedName("vehicleType") val vehicleType: String,
    @Expose @SerializedName("pricing") val pricing: Pricing
)