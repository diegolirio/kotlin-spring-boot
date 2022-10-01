package com.liriotech.purchaseorder.process.provider.h2.repository

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "orders")
class OrderModel(
    @Id @GeneratedValue
    var idProcess: Long? = null,
    var idOrder: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    val requestValue: BigDecimal? = null,
    val status: String? = null
)