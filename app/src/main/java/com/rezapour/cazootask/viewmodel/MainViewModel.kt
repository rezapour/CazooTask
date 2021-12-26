package com.rezapour.cazootask.viewmodel

import androidx.lifecycle.*
import com.rezapour.cazootask.data.repository.MainRepository
import com.rezapour.cazootask.model.CarsListDetatil
import com.rezapour.cazootask.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _dataStateListOfCars: MutableLiveData<DataState<List<CarsListDetatil>>> =
        MutableLiveData()
    private val dataStatListOfCars: LiveData<DataState<List<CarsListDetatil>>> get() = _dataStateListOfCars

    fun getCarsList() {
        _dataStateListOfCars.value = DataState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getCarList().collect {
                _dataStateListOfCars.postValue(it)
            }
        }
    }

}