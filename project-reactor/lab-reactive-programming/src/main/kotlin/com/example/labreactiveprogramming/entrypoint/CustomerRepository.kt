package com.example.labreactiveprogramming.entrypoint

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class CustomerRepository { //} : ReactiveCrudRepository<Customer, Long> {

    fun findAll(): Flux<Customer> {
        return Flux.just(
            Customer(1, "Diego"),
            Customer(2, "Lucas"),
            Customer(3, "Yan")
        )
    }


}
