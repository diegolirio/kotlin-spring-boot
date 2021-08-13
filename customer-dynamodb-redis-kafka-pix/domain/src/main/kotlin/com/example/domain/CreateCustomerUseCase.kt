package com.example.domain

import com.example.domain.vo.Customer

interface CreateCustomerUseCase {

    fun execute(customer : Customer): Customer

}