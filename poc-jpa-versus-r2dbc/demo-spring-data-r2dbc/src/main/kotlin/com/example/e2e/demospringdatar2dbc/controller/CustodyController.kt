package com.example.e2e.demospringdatar2dbc.controller

import com.example.e2e.demospringdatar2dbc.controller.handle.CustodyHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class CustodyController(
        private val custodyHandler: CustodyHandler
) {

    @Bean
    fun routePosition() = router {
        (CustodyHandler.PATH and accept(MediaType.APPLICATION_JSON)).nest {
            GET(ROOT, custodyHandler::get)
            GET("/update-positions", custodyHandler::updatePositions)
        }
    }

    companion object { const val ROOT = "" }

}