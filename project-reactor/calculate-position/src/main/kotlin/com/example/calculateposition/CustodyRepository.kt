package com.example.calculateposition

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.math.BigDecimal

@Component
class CustodyRepository  {

    private val log = LoggerFactory.getLogger(javaClass)

    fun findAll() : Flux<Custody> {
        log.info("findAll")
        return Flux.just(
            Custody(1, BigDecimal.TEN),
            Custody(2, BigDecimal.TEN),
            Custody(3, BigDecimal.TEN),
            Custody(4, BigDecimal.TEN),
        )
    }

}