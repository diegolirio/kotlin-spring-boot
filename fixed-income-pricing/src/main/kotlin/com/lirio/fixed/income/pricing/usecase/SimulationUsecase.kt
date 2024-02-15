package com.lirio.fixed.income.pricing.usecase

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.math.BigDecimal

@Service
class SimulationUsecase {

    private val log = LoggerFactory.getLogger(javaClass)

    fun exec(simulationRequest: Mono<SimulationRequest>): Mono<PrincingResponse> {

//        simulationRequest
//            .doOnNext {  }

        // IN ->
        // - dataCompra
        // - valorCompra
        // - percentaulDI
        // - puInitial

        // Find on DB
        // - dailyFactor
        // - DI atual (nao precisa no momento)


        // processing
        // - quantity ( valorCompra / puInitial)
        // -


        return Mono.just(
            PrincingResponse(BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN)
        ).also {
            log.info("m=exec, response=$it")
        }.subscribeOn(Schedulers.parallel())
    }

}
