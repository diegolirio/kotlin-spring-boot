package com.example.application.entrypoint

import com.example.application.dto.CustomerRequest
import com.example.application.dto.CustomerResponse
import com.example.domain.CreateCustomerUseCase
import com.example.domain.FindAllCustomersUseCase
import org.springframework.web.bind.annotation.*
import toCustomerResponse
import toCustomerVO
import toCustomersResponse

@RestController
@RequestMapping("/customers")
class CustomerRestController(
        private val createCustomerUseCase: CreateCustomerUseCase,
        private val findAllCustomersUseCase: FindAllCustomersUseCase
) {

    @PostMapping
    fun create(@RequestBody customerRequest: CustomerRequest): CustomerResponse {
        return createCustomerUseCase.execute(customerRequest.toCustomerVO()).toCustomerResponse()
    }

    @GetMapping
    fun getList(): List<CustomerResponse> {
        return findAllCustomersUseCase.execute().toCustomersResponse()
    }

    @GetMapping("/{id}")
    fun getById(id: String): List<CustomerResponse> {
        return findAllCustomersUseCase.execute().toCustomersResponse()
    }
}