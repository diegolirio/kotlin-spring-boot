package com.example.domain

import com.example.domain.inputs.FindAllCustomersInput
import com.example.domain.outputs.FindAllCustomersOutput

class FindAllCustomersUseCase(
        private val findAllCustomersOutput: FindAllCustomersOutput
) : FindAllCustomersInput {

    override fun execute(): List<Customer> = findAllCustomersOutput.findAll()

}