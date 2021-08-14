package com.example.domain.inputs

import com.example.domain.DeleteCustomerUseCase
import com.example.domain.outputs.DeleteCustomerOutput
import com.example.domain.outputs.FindCustomerByIdOutput

class DeleteCustomerInput(
        private val findCustomerByIdOutput: FindCustomerByIdOutput,
        private val deleteCustomerOutput: DeleteCustomerOutput,
) : DeleteCustomerUseCase {

    override fun execute(id: String) {
        findCustomerByIdOutput.findById(id).let(deleteCustomerOutput::deleteById)
    }
}