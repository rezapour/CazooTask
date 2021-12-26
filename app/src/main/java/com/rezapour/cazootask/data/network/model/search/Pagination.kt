package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pagination(
    @Expose @SerializedName("currentPageIndex") val currentPageIndex: Int,
    @Expose @SerializedName("requestPageSize") val requestPageSize: Int,
    @Expose @SerializedName("totalPages") val totalPages: Int,
    @Expose @SerializedName("totalItems") val totalItems: Int
)