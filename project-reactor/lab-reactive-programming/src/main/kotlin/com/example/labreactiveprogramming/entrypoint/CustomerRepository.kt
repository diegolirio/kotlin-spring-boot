package com.example.labreactiveprogramming.entrypoint

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class CustomerRepository { //} : ReactiveCrudRepository<Customer, Long> {

    private val log = LoggerFactory.getLogger(javaClass)

    fun findAll(): Flux<Customer> {
        log.info("findAll")
        return Flux.just(
            Customer(1, "Diego"),
            Customer(2, "Lucas"),
            Customer(3, "Yan")
        )
    }


}
