package com.example.domain.outputs

import com.example.domain.vo.Customer

interface DeleteCustomerOutput {
    fun deleteById(customer: Customer): Unit
}
