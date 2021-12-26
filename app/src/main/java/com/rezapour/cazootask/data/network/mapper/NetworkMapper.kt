package com.rezapour.cazootask.data.network.mapper

import com.rezapour.cazootask.data.network.model.search.Result
import com.rezapour.cazootask.model.CarsListDetatil
import com.rezapour.cazootask.util.DataMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor() : DataMapper<Result, CarsListDetatil> {
    override fun mapFromEntity(entity: Result): CarsListDetatil {
        return CarsListDetatil(
            id = entity.id,
            make = entity.make,
            model = entity.model,
            modelYear = entity.modelYear,
            displayVarient = entity.displayVariant,
            mileage = entity.mileage,
            registrationYear = entity.registrationYear,
            vrm = entity.vrm,
            imageUrl = entity.images.main.url,
            price = entity.pricing.fullPrice.value,
            pcp = entity.pricing.pcmPrice.pcp.value,
            currencyCode = entity.pricing.fullPrice.currencyCode
        )
    }


    fun mapFromEntityList(entityList: List<Result>): List<CarsListDetatil> {
        return entityList.map { mapFromEntity(it) }
    }
}