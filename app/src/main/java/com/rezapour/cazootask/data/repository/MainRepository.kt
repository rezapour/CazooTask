package com.rezapour.cazootask.data.repository

import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.util.DataState
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getCarList(page: Int): Flow<DataState<List<VehicleListDetatil>>>

    suspend fun getVehicleDetail(id: String): Flow<DataState<VehicleNetworkEntity>>

}