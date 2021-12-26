package com.rezapour.cazootask.data.network.retrofit

import com.rezapour.cazootask.assets.Constants
import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.SUB_DOMAIN_SEARCH)
    suspend fun getCarList(): Response<CarListNetworkEntity>

}