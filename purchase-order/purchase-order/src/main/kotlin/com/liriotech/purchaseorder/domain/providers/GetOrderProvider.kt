package com.liriotech.purchaseorder.domain.providers

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import reactor.core.publisher.Flux

interface GetOrderProvider {
    fun get(): Flux<OrderEntity>
}
