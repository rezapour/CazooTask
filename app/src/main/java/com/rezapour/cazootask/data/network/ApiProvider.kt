package com.rezapour.cazootask.data.network

import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import retrofit2.Response
import retrofit2.http.Path

interface ApiProvider {

    suspend fun getCarList(): Response<CarListNetworkEntity>


    suspend fun getVehicleDetail(id: String): Response<VehicleNetworkEntity>
}