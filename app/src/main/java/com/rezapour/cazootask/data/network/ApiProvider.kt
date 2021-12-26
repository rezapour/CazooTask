package com.rezapour.cazootask.data.network

import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import retrofit2.Response

interface ApiProvider {

    suspend fun getCarList(): Response<CarListNetworkEntity>

}