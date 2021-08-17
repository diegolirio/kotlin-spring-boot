package com.example.domain

import com.example.domain.Customer

interface FindCustomerByIdUseCase {

    fun execute(id: String): Customer
}
