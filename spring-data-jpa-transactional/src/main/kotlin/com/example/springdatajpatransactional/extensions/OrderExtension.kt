package com.example.springdatajpatransactional

import com.example.springdatajpatransactional.controllers.data.AddressRequest
import com.example.springdatajpatransactional.controllers.data.CustomerRequest
import com.example.springdatajpatransactional.controllers.data.ProductRequest
import com.example.springdatajpatransactional.models.AddressModel
import com.example.springdatajpatransactional.models.CustomerModel
import com.example.springdatajpatransactional.models.ProductModel
import java.math.BigDecimal

fun CustomerRequest.toModel() : CustomerModel =
    CustomerModel(
        id = this.id,
        cpfCnpj = this.cpfCnpj,
        name = this.name
    )

fun AddressRequest.toModel() : AddressModel =
    AddressModel(
        id = this.id,
        description = this.description
    )

fun ProductRequest.toModel(price: BigDecimal) : ProductModel =
    ProductModel(
        id = this.id,
        description = this.description,
        price = price
    )