package com.rezapour.cazootask.data.network

import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.data.network.retrofit.ApiService
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiProviderImplFack constructor(val apiService: ApiService) : ApiProvider {

    override suspend fun getCarList(page: Int): Response<CarListNetworkEntity> {
        return apiService.getCarList(page)
    }

    override suspend fun getVehicleDetail(id: String): Response<VehicleNetworkEntity> {
        return return apiService.getVehicleDetail(id)
    }
}