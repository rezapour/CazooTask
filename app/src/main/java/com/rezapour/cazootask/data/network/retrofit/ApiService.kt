package com.rezapour.cazootask.data.network.retrofit

import com.rezapour.cazootask.assets.Constants
import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/search")
    suspend fun getCarList(@Query("page") page: Int): Response<CarListNetworkEntity>

    @GET("api/vehicles/{id}")
    suspend fun getVehicleDetail(@Path("id") id: String): Response<VehicleNetworkEntity>


}