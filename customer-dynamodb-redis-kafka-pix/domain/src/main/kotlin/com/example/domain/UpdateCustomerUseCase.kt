package com.example.domain

import com.example.domain.vo.Customer

interface UpdateCustomerUseCase {
    fun execute(id: String, toCustomerVO: Customer): Customer

}
