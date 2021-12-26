package com.rezapour.cazootask.data.network.model.vehicles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CostNetWorkEntity(
    @Expose @SerializedName("centAmount") val centAmount:Double ,
    @Expose @SerializedName("currencyCode") val currencyCode:String ,
    @Expose @SerializedName("value") val value:Double

)
