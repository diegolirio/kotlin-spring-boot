package com.liriotech.purchaseorder.process.provider.h2

import com.liriotech.purchaseorder.process.entities.OrderEntity
import com.liriotech.purchaseorder.process.provider.h2.extensions.toEntity
import com.liriotech.purchaseorder.process.provider.h2.extensions.toModel
import com.liriotech.purchaseorder.process.provider.h2.repository.OrderRepository
import com.liriotech.purchaseorder.process.providers.CreateOrderProcessProvider
import org.springframework.stereotype.Component

@Component
class CreateOrderProcessH2ProviderImpl(
    private val orderRepository: OrderRepository
) : CreateOrderProcessProvider {

    override fun create(orderEntity: OrderEntity): OrderEntity =
        orderRepository.save(
            orderEntity.toModel()
        )
        .toEntity()

}