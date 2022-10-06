package com.liriotech.purchaseorder.domain.entities

import java.math.BigDecimal

data class OrderEntity(
    var id: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    val value: BigDecimal? = null,
    val status: StatusEnum = StatusEnum.PENDING
)
