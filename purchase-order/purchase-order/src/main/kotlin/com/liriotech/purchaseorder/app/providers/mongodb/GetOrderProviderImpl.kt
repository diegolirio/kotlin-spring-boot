package com.liriotech.purchaseorder.app.providers.mongodb

import com.liriotech.purchaseorder.app.providers.mongodb.extensions.toOrderEntity
import com.liriotech.purchaseorder.app.providers.mongodb.repository.OrderRepository
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.GetOrderProvider
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class GetOrderProviderImpl(
    private val orderRepository: OrderRepository
) : GetOrderProvider {

    override fun get(): Flux<OrderEntity> = orderRepository.findAll().map { it.toOrderEntity() }

}