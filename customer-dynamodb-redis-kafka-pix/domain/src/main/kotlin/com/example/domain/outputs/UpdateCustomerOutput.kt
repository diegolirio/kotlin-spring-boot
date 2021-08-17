package com.example.domain.outputs

import com.example.domain.Customer

interface UpdateCustomerOutput {
    fun update(customer: Customer): Customer
}
