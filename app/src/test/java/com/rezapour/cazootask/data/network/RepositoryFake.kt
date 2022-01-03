package com.rezapour.cazootask.data.network

import com.rezapour.cazootask.assets.Messages
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.data.repository.VehicleDataRepository
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RepositoryFake : VehicleDataRepository {

    private val listVehicle = mutableListOf<VehicleListDetatil>()
    private val vehicleNetworkEntity: VehicleNetworkEntity? = null

    private var networkRespondError = false

    fun setNetworkRespondError(value: Boolean) {
        networkRespondError = value
    }


    override suspend fun getCarList(page: Int): Flow<DataState<List<VehicleListDetatil>>> = flow {
        if (networkRespondError)
            emit(DataState.Success(listVehicle))
        else
            emit(DataState.Error(Messages.INTERNET_CONNECTION_LIST))
    }

    override suspend fun getVehicleDetail(id: String): Flow<DataState<VehicleNetworkEntity>> =
        flow {
            if (networkRespondError)
                emit(DataState.Success(vehicleNetworkEntity!!))
            else
                emit(DataState.Error(Messages.INTERNET_CONNECTION_LIST))
        }


}