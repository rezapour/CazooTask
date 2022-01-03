package com.rezapour.cazootask.view.vehicledetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValueTest
import com.google.common.truth.Truth
import com.rezapour.cazootask.data.network.RepositoryFake
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.utli.MainCoroutineRule
import com.rezapour.cazootask.view.vehicledetail.viewmodel.VehicleDetatilViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.internal.wait
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
class VehicleDetatilViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: VehicleDetatilViewModel
    private lateinit var repository: RepositoryFake

    @Before
    fun setUp() {
        repository = RepositoryFake()
        viewModel = VehicleDetatilViewModel(repository)
    }

    @Test
    fun `getVehicleDetail success network respond`() {
        repository.setNetworkRespondError(true)
        viewModel.getVehicleDetail("1")
        Truth.assertThat(viewModel.dataState.getOrAwaitValueTest())
            .isInstanceOf(DataState.Loading::class.java)
        Truth.assertThat(viewModel.dataState.getOrAwaitValueTest())
            .isInstanceOf(DataState.Success::class.java)

    }


    @Test
    fun `getVehicleDetail error network respond`() {
        repository.setNetworkRespondError(false)
        viewModel.getVehicleDetail("1")
        Truth.assertThat(viewModel.dataState.getOrAwaitValueTest())
            .isInstanceOf(DataState.Loading::class.java)
        Truth.assertThat(viewModel.dataState.getOrAwaitValueTest())
            .isInstanceOf(DataState.Error::class.java)

    }

}