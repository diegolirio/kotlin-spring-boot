package io.github.diegolirio.demospringbootkotlin.service.customer

import org.springframework.stereotype.Service

@Service
class CustomerService {

    fun getById(id: Int): Customer = Customer(id, "Diego", "Lírio")

    fun getAll(): List<Customer> = listOf<Customer>( getById(1))

}