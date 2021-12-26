package com.rezapour.cazootask.di

import com.rezapour.cazootask.data.network.ApiProvider
import com.rezapour.cazootask.data.network.ApiProviderImpl
import com.rezapour.cazootask.data.network.mapper.NetworkMapper
import com.rezapour.cazootask.data.network.retrofit.ApiService
import com.rezapour.cazootask.data.repository.MainRepository
import com.rezapour.cazootask.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideApiHelper(apiService: ApiService): ApiProvider {
        return ApiProviderImpl(apiService)
    }


    @Singleton
    @Provides
    fun provideRepository(
        apiProvider: ApiProvider,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepositoryImpl(apiProvider, networkMapper)
    }


}