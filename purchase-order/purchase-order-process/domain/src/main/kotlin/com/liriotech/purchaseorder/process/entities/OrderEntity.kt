package com.liriotech.purchaseorder.process.entities

import java.math.BigDecimal

data class OrderEntity(
    val id: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    val value: BigDecimal? = null,
    val status: StatusEnum? = null
)