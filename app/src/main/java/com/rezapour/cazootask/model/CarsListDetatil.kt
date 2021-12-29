package com.rezapour.cazootask.model

data class CarsListDetatil(
    val id: String,
    val make: String,
    val model: String,
    val modelYear: Int,
    val displayVarient: String,
    val mileage: Long,
    val mileageUnit: String,
    val registrationYear: Int,
    val vrm: String,
    val imageUrl: String,
    val price: Long,
    val pcp: Long?,
    val currencyCode: String
) {
}