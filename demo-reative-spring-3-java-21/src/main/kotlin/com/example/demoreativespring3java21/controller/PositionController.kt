package com.example.demoreativespring3java21.controller

import com.example.demoreativespring3java21.controller.handler.PositionHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class PositionController(
        private val positionHandler: PositionHandler
) {

    companion object { const val ROOT = "" }

    @Bean
    fun routePosition() = router {
        (PositionHandler.PATH and accept(MediaType.APPLICATION_JSON)).nest {
            GET(ROOT, positionHandler::get)
        }
    }

}