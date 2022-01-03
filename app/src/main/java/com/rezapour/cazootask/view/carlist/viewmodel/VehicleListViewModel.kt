package com.rezapour.cazootask.view.carlist.viewmodel

import androidx.lifecycle.*
import com.rezapour.cazootask.data.repository.VehicleDataRepository
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleListViewModel @Inject constructor(
    private val vehicleDataRepository: VehicleDataRepository
) : ViewModel() {

    private val _dataStateListOfCars: MutableLiveData<DataState<List<VehicleListDetatil>>> =
        MutableLiveData()
    val dataStatListOfVehicles: LiveData<DataState<List<VehicleListDetatil>>> get() = _dataStateListOfCars
    private var vehicleList = ArrayList<VehicleListDetatil>()
    private var page = 1


    fun getCarsPagination() {
        page++
        loadData()
    }

    fun getCarsData() {
        page = 1
        loadData()
    }

    private fun loadData() {
        _dataStateListOfCars.value = DataState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            vehicleDataRepository.getCarList(page).collect { dataState ->
                if (dataState is DataState.Success) {
                    if (page == 1) {
                        vehicleList.clear()
                    }
                    vehicleList.addAll(dataState.data)
                    _dataStateListOfCars.postValue(DataState.Success(vehicleList))
                } else {
                    if (page > 1)
                        page--
                    _dataStateListOfCars.postValue(dataState)

                }
            }
        }
    }

}