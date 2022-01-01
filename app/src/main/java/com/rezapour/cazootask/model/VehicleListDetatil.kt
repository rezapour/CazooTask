package com.rezapour.cazootask.model

data class VehicleListDetatil(
    var id: String,
    var make: String,
    var model: String,
    var modelYear: Int,
    var displayVarient: String,
    var mileage: Long,
    var mileageUnit: String,
    var registrationYear: Int,
    var imageUrl: String,
    var price: Long,
    var pcp: Long?,
    var currencyCode: String
) {
}