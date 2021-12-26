package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class CarListNetworkEntity(
    @SerializedName("results") val results: List<Result>,
    @SerializedName("filters") val filters: Filters,
    @SerializedName("pagination") val pagination: Pagination
)