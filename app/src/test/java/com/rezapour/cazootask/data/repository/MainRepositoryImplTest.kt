package com.rezapour.cazootask.data.repository

import app.cash.turbine.test
import com.google.common.io.Resources.getResource
import com.google.common.truth.Truth.assertThat
import com.rezapour.cazootask.data.network.ApiProviderImplFack
import com.rezapour.cazootask.data.network.RetrofitBuilderMock
import com.rezapour.cazootask.data.network.mapper.NetworkMapper
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.utli.MainCoroutineRule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.File
import java.io.InputStream
import java.net.HttpURLConnection

class MainRepositoryImplTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var mockWebServer: MockWebServer
    lateinit var repository: MainRepositoryImpl
    lateinit var respondBody: String
    lateinit var respondBodyVehicleDetile: String

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        val apiProviderFake =
            ApiProviderImplFack(RetrofitBuilderMock.provideApiService(mockWebServer))
        repository = MainRepositoryImpl(apiProviderFake, NetworkMapper())


        val inputStream: InputStream =
            File(getResource("searchApiRespond.json").toURI()).inputStream()
        respondBody = inputStream.bufferedReader().use { it.readText() }

        val inputStreamVehicleDetile: InputStream =
            File(getResource("searchApiRespond.json").toURI()).inputStream()
        respondBodyVehicleDetile = inputStreamVehicleDetile.bufferedReader().use { it.readText() }

    }

    @After
    fun destroy() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getCars() test Success`() {
        val mock = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(respondBody)
        mockWebServer.enqueue(mock)

        runBlocking {
            repository.getCarList().test {
                assertThat(awaitItem()).isInstanceOf(DataState.Success::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `getCars() test Error`() {
        val mock = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_NO_CONTENT)
            .setBody(respondBody)
        mockWebServer.enqueue(mock)

        runBlocking {
            repository.getCarList().test {
                assertThat(awaitItem()).isInstanceOf(DataState.Error::class.java)
                awaitComplete()
            }
        }
    }


    @Test
    fun `getVehicleDeties () test Success`() {
        val mock = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(respondBodyVehicleDetile)
        mockWebServer.enqueue(mock)

        runBlocking {
            repository.getVehicleDetail("1").test {
                assertThat(awaitItem()).isInstanceOf(DataState.Success::class.java)
                awaitComplete()
            }
        }
    }


    @Test
    fun `getVehicleDetail() test Error no content`() {
        val mock = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_NO_CONTENT)
            .setBody(respondBodyVehicleDetile)
        mockWebServer.enqueue(mock)

        runBlocking {
            repository.getVehicleDetail("1").test {
                assertThat(awaitItem()).isInstanceOf(DataState.Error::class.java)
                awaitComplete()
            }
        }
    }

    @Test
    fun `getVehicleDeties() test Error`() {
        val mock = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_GATEWAY_TIMEOUT)
            .setBody(respondBodyVehicleDetile)
        mockWebServer.enqueue(mock)

        runBlocking {
            repository.getVehicleDetail("1").test {
                assertThat(awaitItem()).isInstanceOf(DataState.Error::class.java)
                awaitComplete()
            }
        }
    }

}