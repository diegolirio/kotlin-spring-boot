package com.liriotech.purchaseorder.domain.providers

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import reactor.core.publisher.Mono

interface CreateOrderProvider {
    fun create(orderEntity: OrderEntity): Mono<OrderEntity>
}
