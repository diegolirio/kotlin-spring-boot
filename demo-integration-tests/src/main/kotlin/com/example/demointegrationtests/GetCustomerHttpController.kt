package com.example.demointegrationtests

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customers")
class GetCustomerHttpController(
    private val usecase: Usecase
) {

    @GetMapping
    fun get() : Iterable<Customer> {
        return usecase.getList()
    }
}

@Component
class Usecase(
    private val repository: CustomerRepository
) {
    fun getList(): Iterable<Customer> = repository.findAll()
}

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {

}

@Entity
data class Customer(
    @Id @GeneratedValue var id: Long? = null
)