package com.liriotech.purchaseorder.app.entrypoints.http.extensions

import com.liriotech.purchaseorder.app.entrypoints.http.data.OrderRequest
import com.liriotech.purchaseorder.domain.entities.OrderEntity

fun OrderRequest.toOrderEntity() : OrderEntity {
    return OrderEntity(
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value
    )
}