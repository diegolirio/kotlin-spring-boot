package com.example.domain

import com.example.domain.Customer

interface CreateCustomerUseCase {

    fun execute(customer : Customer): Customer

}