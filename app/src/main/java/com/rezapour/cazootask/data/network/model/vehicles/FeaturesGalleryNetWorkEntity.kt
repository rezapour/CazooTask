package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FeaturesGalleryNetWorkEntity (
    @Expose @SerializedName("coordinates") val coordinates:CoordinatesNetWorkEntity,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("image") val image: ImageLinkNetWorkEntity,
    @Expose @SerializedName("parentImage") val parentImage: ImageLinkNetWorkEntity,
    @Expose @SerializedName("title") val title: String,



)
