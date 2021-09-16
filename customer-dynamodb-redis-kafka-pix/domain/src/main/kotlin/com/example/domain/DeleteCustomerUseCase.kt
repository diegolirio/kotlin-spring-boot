package com.example.domain

import com.example.domain.inputs.DeleteCustomerInput
import com.example.domain.outputs.DeleteCustomerOutput
import com.example.domain.outputs.FindCustomerByIdOutput

class DeleteCustomerUseCase(
        private val findCustomerByIdOutput: FindCustomerByIdOutput,
        private val deleteCustomerOutput: DeleteCustomerOutput,
) : DeleteCustomerInput {

    override fun execute(id: String) {
        findCustomerByIdOutput.findById(id).let(deleteCustomerOutput::deleteById)
    }
}