package com.liriotech.purchaseorder.app.providers.kafka

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import org.springframework.stereotype.Component

@Component
class OrderKafkaProducer : NotifyChangesProvider {

    override fun send(orderEntity: OrderEntity) =
        println("orderEntity Notified = $orderEntity ")
}