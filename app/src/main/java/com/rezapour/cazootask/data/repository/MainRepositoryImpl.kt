package com.rezapour.cazootask.data.repository

import com.rezapour.cazootask.assets.Messages
import com.rezapour.cazootask.data.network.ApiProvider
import com.rezapour.cazootask.data.network.mapper.NetworkMapper
import com.rezapour.cazootask.model.CarsListDetatil
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
    override suspend fun getCarList(): Flow<DataState<List<CarsListDetatil>>> = flow {
        emit(DataState.Loading)
        try {
            val response = apiProvider.getCarList()
            if (response.isSuccessful && response.body() != null) {
                val cars = netWorkMapper.mapFromEntityList(response.body()!!.results)
                emit(DataState.Success(cars))
            } else {
                emit(DataState.Error(Messages.Error.NO_CONTENT))
            }

        } catch (e: Exception) {
            val ed = e
            emit(DataState.Error(Messages.Error.INTERNET_CONNECTION_LIST))
        }


    }
}