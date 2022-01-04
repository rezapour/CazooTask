package com.rezapour.cazootask.view.carlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValueTest
import com.rezapour.cazootask.data.network.RepositoryFake
import com.rezapour.cazootask.utli.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import com.rezapour.cazootask.util.DataState
import com.rezapour.cazootask.view.carlist.viewmodel.VehicleListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

import org.junit.Test


@ExperimentalCoroutinesApi
class VehicleListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: VehicleListViewModel
    private lateinit var repository: RepositoryFake

    @Before
    fun setUp() {
        repository = RepositoryFake()
        viewModel = VehicleListViewModel(repository)
    }

    @Test
    fun `getCarsPagination success network respond`() {
        repository.setNetworkRespondError(true)
        viewModel.getCarsData()
        val valueloading = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueloading).isInstanceOf(DataState.Loading::class.java)
        val valueRespond = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueRespond).isInstanceOf(DataState.Success::class.java)

    }

    @Test
    fun `getCarsPagination network error`() {
        repository.setNetworkRespondError(false)
        viewModel.getCarsData()
        val valueloading = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueloading).isInstanceOf(DataState.Loading::class.java)
        val valueRespond = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueRespond).isInstanceOf(DataState.Error::class.java)

    }

    @Test
    fun `getCarsData success`() {
        repository.setNetworkRespondError(true)
        viewModel.getCarsData()

        assertThat(viewModel.dataStatListOfVehicles.getOrAwaitValueTest()).isInstanceOf(DataState.Loading::class.java)
        val valueRespond = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueRespond).isInstanceOf(DataState.Success::class.java)

    }


    @Test
    fun `getCarsData error`() {
        repository.setNetworkRespondError(false)
        viewModel.getCarsData()

        assertThat(viewModel.dataStatListOfVehicles.getOrAwaitValueTest()).isInstanceOf(DataState.Loading::class.java)
        val valueRespond = viewModel.dataStatListOfVehicles.getOrAwaitValueTest()
        assertThat(valueRespond).isInstanceOf(DataState.Error::class.java)

    }
}