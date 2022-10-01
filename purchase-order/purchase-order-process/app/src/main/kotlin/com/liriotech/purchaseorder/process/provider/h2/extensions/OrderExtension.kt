package com.liriotech.purchaseorder.process.provider.h2.extensions

import com.liriotech.purchaseorder.process.entities.OrderEntity
import com.liriotech.purchaseorder.process.entities.StatusEnum
import com.liriotech.purchaseorder.process.provider.h2.repository.OrderModel

fun OrderEntity.toModel(): OrderModel =
    OrderModel(
        idProcess = this.idProcess,
        idOrder = this.id,
        productCode = this.productCode,
        customerId = this.customerId,
        requestValue = this.value,
        status = this.status!!.name
    )

fun OrderModel.toEntity(): OrderEntity =
    OrderEntity(
        idProcess = this.idProcess,
        id = this.idOrder,
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.requestValue,
        status = this.status?.let { StatusEnum.valueOf(it) }
    )