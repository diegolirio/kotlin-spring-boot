package com.example.calculateposition

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class CustodyController(
    private val custodyHandler: CustodyHandler
) {

    @Bean
    fun routePosition() = router {
        ("/custody" and accept(MediaType.APPLICATION_JSON)).nest {
            GET(ROOT, custodyHandler::get)
        }
    }

    companion object { const val ROOT = "" }

}

@Component
class CustodyHandler(
    private  val usecase: CustodyUsecase
) {

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse
            .ok()
            .body(usecase.findAll(), Custody::class.java)
}
