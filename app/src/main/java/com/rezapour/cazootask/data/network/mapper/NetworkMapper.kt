package com.rezapour.cazootask.data.network.mapper

import com.rezapour.cazootask.data.network.model.search.Result
import com.rezapour.cazootask.model.VehicleListDetatil
import com.rezapour.cazootask.util.DataMapper
import java.util.*
import javax.inject.Inject

class NetworkMapper @Inject constructor() : DataMapper<Result, VehicleListDetatil> {
    override fun mapFromEntity(entity: Result): VehicleListDetatil {
        var pcp: Long? = 0
        if (entity.pricing.pcmPrice != null)
            entity.pricing.pcmPrice.let { it.pcp?.let { pcp = it.value } }
        return VehicleListDetatil(
            id = entity.id,
            make = entity.make,
            model = entity.model,
            modelYear = entity.modelYear,
            displayVarient = entity.displayVariant,
            mileage = entity.mileage,
            mileageUnit = entity.odometerReading.unit,
            registrationYear = entity.registrationYear,
            imageUrl = entity.images.main.url,
            price = entity.pricing.fullPrice.value,
            pcp = pcp,
            currencyCode = entity.pricing.fullPrice.currencyCode
        )

    }


    fun mapFromEntityList(entityList: List<Result>): List<VehicleListDetatil> {
        return entityList.map { mapFromEntity(it) }
    }
}