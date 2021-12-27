package com.rezapour.cazootask.viewmodel

import androidx.lifecycle.*
import com.rezapour.cazootask.data.network.model.vehicles.VehicleNetworkEntity
import com.rezapour.cazootask.data.repository.MainRepository
import com.rezapour.cazootask.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class VehicleDetatilViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: MainRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<VehicleNetworkEntity>> = MutableLiveData()
    val dataState: LiveData<DataState<VehicleNetworkEntity>> get() = _dataState


    fun getVehicleDetail(id: String) {
        _dataState.value = DataState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            repository.getVehicleDetail(id).collect { dataState ->
                _dataState.postValue(dataState)
            }
        }
    }


}