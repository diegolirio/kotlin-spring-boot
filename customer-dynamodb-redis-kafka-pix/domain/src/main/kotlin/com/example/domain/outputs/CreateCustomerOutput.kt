package com.example.domain.outputs

import com.example.domain.Customer

interface CreateCustomerOutput {
    fun create(customer: Customer): Customer
}
