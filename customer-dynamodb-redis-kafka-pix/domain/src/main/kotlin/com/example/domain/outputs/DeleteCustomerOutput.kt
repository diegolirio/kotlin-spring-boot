package com.example.domain.outputs

import com.example.domain.Customer

interface DeleteCustomerOutput {
    fun deleteById(customer: Customer): Unit
}
