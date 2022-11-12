package com.example.springdatajpatransactional.controllers.data

import java.math.BigDecimal

data class OrderRequest(
    val customer: CustomerRequest,
    val items: List<OrderProductRequest>
)

data class OrderProductRequest(
    val product: ProductRequest,
    val amount: Int,
    val price: BigDecimal
)

data class ProductRequest(
    var id: Long? = null,
    val description: String
)

data class CustomerRequest(
    var id: Long? = null,
    val cpfCnpj: String,
    val name: String,
    val address: AddressRequest,
)

data class AddressRequest(
    var id: Long? = null,
    val description: String
)
