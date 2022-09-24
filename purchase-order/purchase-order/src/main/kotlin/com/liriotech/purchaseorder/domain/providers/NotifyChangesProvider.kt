package com.liriotech.purchaseorder.domain.providers

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import reactor.core.publisher.Mono

interface NotifyChangesProvider {
    fun send(orderEntity: OrderEntity)
}
