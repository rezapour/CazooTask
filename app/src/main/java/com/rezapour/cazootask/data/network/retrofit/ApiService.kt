package com.rezapour.cazootask.data.network.retrofit

import com.rezapour.cazootask.assets.Constants
import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(Constants.SUB_DOMAIN_SEARCH)
    suspend fun getCarList(): Response<CarListNetworkEntity>

    @GET(Constants.SUB_DOMAIN_VEHICLE)
    suspend fun getVehicleDetail(@Path("id") id: String): Response<VehicleNetworkEntity>


}