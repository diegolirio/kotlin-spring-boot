package com.liriotech.purchaseorder.app.providers.kafka.extensions

import com.liriotech.purchaseorder.app.providers.kafka.avro.data.OrderAvro
import com.liriotech.purchaseorder.domain.entities.OrderEntity

fun OrderEntity.toAvro() : OrderAvro =
    OrderAvro(
        this.id,
        this.customerId,
        this.productCode,
        this.value
    )
