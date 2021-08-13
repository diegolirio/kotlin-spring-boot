package com.example.domain.inputs

import com.example.domain.CreateCustomerUseCase
import com.example.domain.vo.Customer
import java.util.*

class CreateCustomerInput : CreateCustomerUseCase {

    override fun execute(customer: Customer): Customer {
        return Customer(
            id = UUID.randomUUID().toString(),
            name = "Diego ",
            age = 21
        )
    }
}