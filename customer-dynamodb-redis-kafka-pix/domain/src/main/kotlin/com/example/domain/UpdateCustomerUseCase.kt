package com.example.domain

import com.example.domain.Customer

interface UpdateCustomerUseCase {
    fun execute(id: String, toCustomerVO: Customer): Customer

}
