package com.rezapour.cazootask.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rezapour.cazootask.assets.Constants
import com.rezapour.cazootask.data.network.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.WebSocket
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

object RetrofitBuilderMock {


    private fun gsonConverterFactoryProvider(): GsonConverterFactory {
        return GsonConverterFactory.create(gsonBuilderProvider())
    }


    private fun gsonBuilderProvider(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }


    private fun okhttpClientProvider(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
            .build()
    }


    fun provideApiService(mockWebServer: MockWebServer): ApiService {
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(gsonConverterFactoryProvider())
            .client(okhttpClientProvider())
            .build().create(ApiService::class.java)
    }
}
