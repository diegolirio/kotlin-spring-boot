package com.example.domain

import com.example.domain.inputs.UpdateCustomerInput
import com.example.domain.outputs.FindCustomerByIdOutput
import com.example.domain.outputs.UpdateCustomerOutput


class UpdateCustomerUseCase(
        private val updateCustomerOutput: UpdateCustomerOutput,
        private val findCustomerByIdOutput: FindCustomerByIdOutput
) : UpdateCustomerInput {

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
