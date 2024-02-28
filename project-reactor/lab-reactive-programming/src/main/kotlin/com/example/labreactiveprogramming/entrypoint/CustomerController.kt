package com.example.labreactiveprogramming.entrypoint

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.time.Duration

@Configuration
class CustomerController(
    private val customerHandler: CustomerHandler
) {

    @Bean
    fun route() = router {
        ("/customers" and RequestPredicates.accept(MediaType.APPLICATION_JSON)).nest {
            GET("", customerHandler::get)
        }
    }

}

@Component
class CustomerHandler(
    private val customerUsecase: CustomerUsecase
) {

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .body(
                customerUsecase.getList(), Customer::class.java
            )
    }

}


@Service
class CustomerUsecase(
    private val repository: CustomerRepository
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun getList(): Flux<Customer> {
        return repository.findAll()
            .delayElements(Duration.ofSeconds(5))
            .log()
            .doOnNext { log.info("Calculando, Enviando para um Kafka-Topic") }
            .doOnNext { log.info("thread=${Thread.currentThread().name}, virtual=${Thread.currentThread().isVirtual}") }
            .subscribeOn(Schedulers.parallel())
            // parallel ----> CPU
            // boundedElastic ---> saida da infraestrutura
    }

}



