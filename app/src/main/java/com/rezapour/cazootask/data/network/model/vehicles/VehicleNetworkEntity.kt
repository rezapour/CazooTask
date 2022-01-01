package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rezapour.cazootask.data.network.model.search.*

data class VehicleNetworkEntity(
    @Expose @SerializedName("isSold") val isSold: Boolean,
    @Expose @SerializedName("state") val state: String,
    @Expose @SerializedName("makeIdentifier") val makeIdentifier: String,
    @Expose @SerializedName("modelIdentifier") val modelIdentifier: String,
    @Expose @SerializedName("manufacturerSpecs") val manufacturerSpecs: List<ManufacturerSpecsNetWorkEntity>,
    @Expose @SerializedName("verifiedFeatures") val verifiedFeatures: List<VerifiedFeaturesNetWorkEntity>,
    @Expose @SerializedName("summaryAttributes") val summaryAttributes: List<DisplayValueNetworkEntity>,
    @Expose @SerializedName("runningCosts") val runningCosts: RunningCostsNetWorkEntity,
    @Expose @SerializedName("keyFeatures") val keyFeatures: List<AttributesNetwrokEntity>,
    @Expose @SerializedName("vehicleHistory") val vehicleHistory: VehicleHistoryNetworkEntity,
    @Expose @SerializedName("imageGallery") val imageGallery: List<ImageLinkNetWorkEntity>,
    @Expose @SerializedName("featuresGallery") val featuresGallery: List<FeaturesGalleryNetWorkEntity>,
    @Expose @SerializedName("imperfectionsGallery") val imperfectionsGallery: List<FeaturesGalleryNetWorkEntity>,
    @Expose @SerializedName("closeDoors360") val closeDoors360: List<ImageLinkNetWorkEntity>,
    @Expose @SerializedName("openDoors360") val openDoors360: List<ImageLinkNetWorkEntity>,
    @Expose @SerializedName("internal360") val internal360: String,
    @Expose @SerializedName("serviceHistoryDocumentationFound") val serviceHistoryDocumentationFound: Boolean,
    @Expose @SerializedName("serviceHistory") val serviceHistory: List<ServiceHistoryNetworkEntity>,
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
    @Expose @SerializedName("pricing") val pricing: Pricing,
    @Expose @SerializedName("consumption") val consumption: List<DisplayValueNetworkEntity>


)