package com.example.domain.inputs

import com.example.domain.FindAllCustomersUseCase
import com.example.domain.outputs.FindAllCustomersOutput
import com.example.domain.vo.Customer

class FindAllCustomersInput(
        private val findAllCustomersOutput: FindAllCustomersOutput
) : FindAllCustomersUseCase {

    override fun execute(): List<Customer> = findAllCustomersOutput.findAll()

}