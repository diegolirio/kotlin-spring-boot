package com.example.domain.inputs

import com.example.domain.Customer

interface FindCustomerByIdInput {

    fun execute(id: String): Customer
}