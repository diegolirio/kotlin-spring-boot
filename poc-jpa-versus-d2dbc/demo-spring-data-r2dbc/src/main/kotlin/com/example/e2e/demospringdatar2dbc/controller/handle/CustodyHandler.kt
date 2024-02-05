package com.example.e2e.demospringdatar2dbc.controller.handle

import com.example.e2e.demospringdatar2dbc.entity.CustodyEntity
import com.example.e2e.demospringdatar2dbc.service.CustodyService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class CustodyHandler(
        private val service: CustodyService
) {

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse
                    .ok()
                    .body(service.getAll(), CustodyEntity::class.java)

    fun updatePositions(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse
                    .ok()
                    .body(service.updatePositions(), Boolean::class.java)

    companion object {
        const val PATH = "/custody"
    }

}
