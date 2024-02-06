package com.example.demoreativespring3java21.controller.handler

import com.example.demoreativespring3java21.entity.PositionEntity
import com.example.demoreativespring3java21.usecase.PositionUsecase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PositionHandler(
        private val usecase: PositionUsecase
) {
    companion object {
        const val PATH = "/position"
    }

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse
                .ok()
                .body(usecase.get(), PositionEntity::class.java)


}
