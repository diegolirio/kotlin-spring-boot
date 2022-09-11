package com.liriotech.purchaseorder.app.entrypoints.http.data

import java.math.BigDecimal

data class OrderRequest(
    val productCode: String? = null,
    val value: BigDecimal? = null,
    val customerId: String? = null
)
