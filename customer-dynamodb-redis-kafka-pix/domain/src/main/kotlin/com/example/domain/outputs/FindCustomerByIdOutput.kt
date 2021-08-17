package com.example.domain.outputs

import com.example.domain.Customer

interface FindCustomerByIdOutput {
    fun findById(id: String): Customer
}
