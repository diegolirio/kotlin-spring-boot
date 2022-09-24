package com.liriotech.purchaseorder.app.providers.mongodb.repository

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(value = "orders")
class Order(
    var id: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    val value: BigDecimal? = null
)