package com.example.democacheabstraction.controller

import com.example.democacheabstraction.client.CustomerInAnotherServiceClient
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customers")
class CustomerController(
    private val customerInAnotherServiceClient: CustomerInAnotherServiceClient
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String) =
        customerInAnotherServiceClient
            .getCustomer(id)

}