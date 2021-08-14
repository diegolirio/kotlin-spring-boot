package com.example.domain.outputs

import com.example.domain.vo.Customer

interface UpdateCustomerOutput {
    fun update(customer: Customer): Customer
}
