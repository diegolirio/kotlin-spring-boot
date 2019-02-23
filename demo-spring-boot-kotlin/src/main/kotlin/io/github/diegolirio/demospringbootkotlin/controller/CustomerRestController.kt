package io.github.diegolirio.demospringbootkotlin.controller

import io.github.diegolirio.demospringbootkotlin.service.customer.Customer
import io.github.diegolirio.demospringbootkotlin.service.customer.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerRestController(private val customerService: CustomerService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): Customer {
        val customer : Customer = customerService.getById(id)
        return customer
    }


    @GetMapping
    fun getAll(): List<Customer> {
        return customerService.getAll()
    }
}
