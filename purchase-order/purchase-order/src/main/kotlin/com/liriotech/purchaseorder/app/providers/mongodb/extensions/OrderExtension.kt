package com.liriotech.purchaseorder.app.providers.mongodb.extensions

import com.liriotech.purchaseorder.app.providers.mongodb.repository.Order
import com.liriotech.purchaseorder.domain.entities.OrderEntity

fun OrderEntity.toOrder() : Order {
    return Order(
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value
    )
}

fun Order.toOrderEntity() : OrderEntity {
    return OrderEntity(
        id = this.id,
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value
    )
}