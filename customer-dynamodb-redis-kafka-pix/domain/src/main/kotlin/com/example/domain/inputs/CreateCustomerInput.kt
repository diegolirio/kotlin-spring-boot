package com.example.domain.inputs

import com.example.domain.CreateCustomerUseCase
import com.example.domain.outputs.CreateCustomerOutput
import com.example.domain.vo.Customer
import java.util.*

class CreateCustomerInput(
        private  val createCustomerOutput: CreateCustomerOutput
) : CreateCustomerUseCase {

    override fun execute(customer: Customer): Customer {
        if(customer.id == null) {
            customer.id = UUID.randomUUID().toString()
            return createCustomerOutput.create(customer)
        }
        throw NotImplementedError()
    }
}