package com.example.domain

import com.example.domain.vo.Customer

interface FindCustomerByIdUseCase {

    fun execute(id: String): Customer
}
