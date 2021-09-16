package com.example.domain

import com.example.domain.inputs.CreateCustomerInput
import com.example.domain.outputs.CreateCustomerOutput
import java.util.*


class CreateCustomerUseCase(
        private  val createCustomerOutput: CreateCustomerOutput
) : CreateCustomerInput {

    override fun execute(customer: Customer): Customer {
        if(customer.id == null) {
            customer.id = UUID.randomUUID().toString()
            return createCustomerOutput.create(customer)
        }
        throw NotImplementedError()
    }
}