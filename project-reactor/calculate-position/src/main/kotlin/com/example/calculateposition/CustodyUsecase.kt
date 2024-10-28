package com.example.calculateposition

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

@Service
class CustodyUsecase(
    private val repository: CustodyRepository
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun findAll() : Flux<Custody> {
        return repository
            .findAll()
            .log()
            .publishOn(Schedulers.parallel())
            .map(::calc)
            .subscribeOn(Schedulers.boundedElastic())
            .doOnNext {
                // kafka producer
                log.info("producer => $it")
            }
            .subscribeOn(Schedulers.boundedElastic())
    }

    private fun calc(custody: Custody): Custody {
        log.info("Calc => $custody")
        return custody
    }


}