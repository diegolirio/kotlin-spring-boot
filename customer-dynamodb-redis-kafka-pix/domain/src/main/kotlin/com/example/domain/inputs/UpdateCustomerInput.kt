package com.example.domain.inputs

import com.example.domain.UpdateCustomerUseCase
import com.example.domain.outputs.FindCustomerByIdOutput
import com.example.domain.outputs.UpdateCustomerOutput
import com.example.domain.Customer

class UpdateCustomerInput(
        private val updateCustomerOutput: UpdateCustomerOutput,
        private val findCustomerByIdOutput: FindCustomerByIdOutput
) : UpdateCustomerUseCase {

    override fun execute(id: String, toCustomerVO: Customer): Customer {
        findCustomerByIdOutput.findById(id).let {
            return updateCustomerOutput.update(
                customer = Customer(
                    id = it.id,
                    name = toCustomerVO.name,
                    age = toCustomerVO.age,
                )
            )
        }
    }
}