package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CarListNetworkEntity(
    @Expose @SerializedName("results") val results: List<Result>,
    @Expose @SerializedName("filters") val filters: Filters,
    @Expose @SerializedName("pagination") val pagination: Pagination
)