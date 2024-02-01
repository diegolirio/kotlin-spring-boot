package com.example.reactorblockhound

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class CustomerEntrypoint {

    @GetMapping
    fun get(): Mono<Customer> {
        return Mono.just(
            Customer(
            firstname = "Diego",
                lastname = "Lirio"
            )
        )
    }
}

class Customer(
    var firstname: String?,
    var lastname: String?
)