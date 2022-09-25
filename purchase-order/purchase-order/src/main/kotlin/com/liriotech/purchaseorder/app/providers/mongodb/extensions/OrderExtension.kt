package com.liriotech.purchaseorder.app.providers.mongodb.extensions

import com.liriotech.purchaseorder.app.providers.mongodb.repository.Order
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.entities.StatusEnum

fun OrderEntity.toOrder(): Order {
    return Order(
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value,
        status = this.status.toString()
    )
}

fun Order.toOrderEntity(): OrderEntity {
    return OrderEntity(
        id = this.id,
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value,
        status = StatusEnum.valueOf(this.status.toString())
    )
}
