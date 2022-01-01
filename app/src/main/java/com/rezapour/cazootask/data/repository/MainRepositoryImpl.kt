package com.rezapour.cazootask.data.repository

import com.rezapour.cazootask.assets.Messages
import com.rezapour.cazootask.data.network.ApiProvider
import com.rezapour.cazootask.data.network.mapper.NetworkMapper
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiProvider: ApiProvider,
    private val netWorkMapper: NetworkMapper
) :
    MainRepository {
    override suspend fun getCarList(page: Int): Flow<DataState<List<VehicleListDetatil>>> = flow {
        try {
            val response = apiProvider.getCarList(page)
            if (response.isSuccessful && response.body() != null) {
                val cars = netWorkMapper.mapFromEntityList(response.body()!!.results)
                emit(DataState.Success(cars))
            } else {
                emit(DataState.Error(Messages.Error.NO_CONTENT))
            }
        } catch (e: Exception) {
//            emit(DataState.Error(Messages.Error.INTERNET_CONNECTION_LIST))
            emit(DataState.Error(e.message.toString()))
        }
    }

    override suspend fun getVehicleDetail(id: String): Flow<DataState<VehicleNetworkEntity>> =
        flow {
            try {
                val response = apiProvider.getVehicleDetail(id)
                if (response.isSuccessful && response.body() != null) {
                    emit(DataState.Success(response.body()!!))
                } else {
                    emit(DataState.Error(Messages.Error.NO_CONTENT))
                }
            } catch (e: Exception) {
                val ex = e
                emit(DataState.Error(Messages.Error.INTERNET_CONNECTION_LIST))
            }
        }
}