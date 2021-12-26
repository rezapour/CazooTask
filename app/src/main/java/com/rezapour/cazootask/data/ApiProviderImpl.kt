package com.rezapour.cazootask.data

import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.retrofit.ApiService
import retrofit2.Response
import javax.inject.Inject

class ApiProviderImpl @Inject constructor(private val apiService: ApiService) : ApiProvider {
    override suspend fun getCarList(): Response<CarListNetworkEntity> {
        return apiService.getCarList()
    }
}