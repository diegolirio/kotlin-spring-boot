package com.liriotech.purchaseorder.app.providers.mongodb

import com.liriotech.purchaseorder.app.providers.mongodb.extensions.toOrder
import com.liriotech.purchaseorder.app.providers.mongodb.extensions.toOrderEntity
import com.liriotech.purchaseorder.app.providers.mongodb.repository.OrderRepository
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.CreateOrderProvider
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CreateOrderProviderImpl(
    private val orderRepository : OrderRepository
) : CreateOrderProvider {

    override fun create(orderEntity: OrderEntity): Mono<OrderEntity> =
        orderRepository
            .save(orderEntity.toOrder())
            .map { it.toOrderEntity() }

}