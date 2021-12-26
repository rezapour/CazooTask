package com.rezapour.cazootask.util

sealed class DataState<out R> {
    class Success<out T>(val data: T) : DataState<T>()
    class Error(val message: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}