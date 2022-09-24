package com.liriotech.purchaseorder.domain.entities

import java.math.BigDecimal

data class OrderEntity(
    val id: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    val value: BigDecimal? = null
)