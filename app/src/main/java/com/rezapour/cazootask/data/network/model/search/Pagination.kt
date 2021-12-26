package com.rezapour.cazootask.data.network.model.search


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("currentPageIndex") val currentPageIndex: Int,
    @SerializedName("requestPageSize") val requestPageSize: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("totalItems") val totalItems: Int
)