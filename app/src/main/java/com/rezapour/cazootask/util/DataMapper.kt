package com.rezapour.cazootask.util

interface DataMapper<Entity, Domain> {
    fun mapFromEntity(entity: Entity): Domain
}