package com.example.domain

import com.example.domain.inputs.FindCustomerByIdInput
import com.example.domain.outputs.FindCustomerByIdOutput

class FindCustomerByIdUseCase(
        private val findCustomerByIdOutput: FindCustomerByIdOutput
) : FindCustomerByIdInput {

    override fun execute(id: String): Customer {
        return findCustomerByIdOutput.findById(id)
    }
}