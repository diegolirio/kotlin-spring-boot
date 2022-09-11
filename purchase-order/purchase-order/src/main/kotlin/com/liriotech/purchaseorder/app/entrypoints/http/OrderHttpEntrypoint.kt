package com.liriotech.purchaseorder.app.entrypoints.http

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class OrderHttpEntrypoint(
    private val orderHandler: OrderHandler
) {

    companion object { const val ROOT = "" }

    @Bean
    fun routeOrder() = router {
        (OrderHandler.ORDER_API and accept(MediaType.APPLICATION_JSON)).nest {
            POST(ROOT, orderHandler::create)
        }
    }
}