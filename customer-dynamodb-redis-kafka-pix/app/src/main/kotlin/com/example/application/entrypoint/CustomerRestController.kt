package com.example.application.entrypoint

import com.example.application.dto.CustomerRequest
import com.example.application.dto.CustomerResponse
import com.example.domain.CreateCustomerUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import toCustomerResponse
import toCustomerVO

@RestController
@RequestMapping("/customers")
class CustomerRestController(
        private val createCustomerUseCase: CreateCustomerUseCase
) {

    @PostMapping
    fun create(customerRequest: CustomerRequest): CustomerResponse {
        return createCustomerUseCase.execute(customerRequest.toCustomerVO()).toCustomerResponse()
    }
}