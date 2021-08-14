package com.example.domain.outputs

import com.example.domain.vo.Customer

interface CreateCustomerOutput {
    fun create(customer: Customer): Customer
}
