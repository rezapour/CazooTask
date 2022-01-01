package com.rezapour.cazootask.data.network

import com.rezapour.cazootask.data.network.ApiProvider
import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.data.network.retrofit.ApiService
import retrofit2.Response
import javax.inject.Inject

class ApiProviderImpl @Inject constructor(private val apiService: ApiService) : ApiProvider {
    override suspend fun getCarList(page: Int): Response<CarListNetworkEntity> {
        return apiService.getCarList(page)
    }

    override suspend fun getVehicleDetail(id: String): Response<VehicleNetworkEntity> {
        return apiService.getVehicleDetail(id)
    }
}