package com.example.demointegrationtests

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/v2/customers")
class GetCustomerExternalHttpController(
    @Value("\${http.client.customer-external}") private val host: String
) {

    @GetMapping("/external")
    fun get(): List<Customer> =
        RestTemplate()
            .exchange(
                "$host/external",
                HttpMethod.GET,
                null,
                object: ParameterizedTypeReference<List<Customer>>() {}
            )
            .body ?: emptyList()

}