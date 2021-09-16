package com.example.domain.inputs

import com.example.domain.Customer

interface CreateCustomerInput {

    fun execute(customer: Customer): Customer
}