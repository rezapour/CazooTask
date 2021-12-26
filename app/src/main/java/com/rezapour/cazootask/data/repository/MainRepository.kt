package com.rezapour.cazootask.data.repository

import com.rezapour.cazootask.data.network.model.search.CarListNetworkEntity
import com.rezapour.cazootask.model.CarsListDetatil
import com.rezapour.cazootask.util.DataState
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getCarList(): Flow<DataState<List<CarsListDetatil>>>

}