package com.lirio.fixed.income.pricing.entrypoint

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class PricingSimulationController(
    private val pricingSimulationHandler: PricingSimulationHandler
) {

    @Bean
    fun routePosition() = router {
        (PricingSimulationHandler.PATH and accept(MediaType.APPLICATION_JSON)).nest {
            POST(ROOT, pricingSimulationHandler::simulation)
        }
    }

    companion object { const val ROOT = "" }

}