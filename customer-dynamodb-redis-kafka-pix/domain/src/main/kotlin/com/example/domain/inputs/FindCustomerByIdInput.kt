package com.example.domain.inputs

import com.example.domain.FindCustomerByIdUseCase
import com.example.domain.outputs.FindCustomerByIdOutput
import com.example.domain.Customer

class FindCustomerByIdInput(
        private val findCustomerByIdOutput: FindCustomerByIdOutput
) : FindCustomerByIdUseCase {

    override fun execute(id: String): Customer {
        return findCustomerByIdOutput.findById(id)
    }
}