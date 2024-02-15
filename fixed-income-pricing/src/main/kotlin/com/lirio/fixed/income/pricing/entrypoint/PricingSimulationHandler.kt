package com.lirio.fixed.income.pricing.entrypoint

import com.lirio.fixed.income.pricing.usecase.PrincingResponse
import com.lirio.fixed.income.pricing.usecase.SimulationRequest
import com.lirio.fixed.income.pricing.usecase.SimulationUsecase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PricingSimulationHandler(
    private val simulationUsecase: SimulationUsecase
) {

    fun simulation(request: ServerRequest) : Mono<ServerResponse> =
        ServerResponse
            .ok()
            .body(
                simulationUsecase.exec(request.bodyToMono(SimulationRequest::class.java)),
                PrincingResponse::class.java
            )

    companion object {
        const val PATH = "/simulation"
    }

}
