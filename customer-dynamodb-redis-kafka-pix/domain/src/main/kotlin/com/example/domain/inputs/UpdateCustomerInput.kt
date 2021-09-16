package com.example.domain.inputs

import com.example.domain.Customer

interface UpdateCustomerInput {

    fun execute(id: String, toCustomerVO: Customer): Customer
}