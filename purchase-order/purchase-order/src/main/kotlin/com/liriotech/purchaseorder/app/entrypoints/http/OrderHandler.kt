package com.liriotech.purchaseorder.app.entrypoints.http

import com.liriotech.purchaseorder.app.entrypoints.http.data.OrderRequest
import com.liriotech.purchaseorder.app.entrypoints.http.extensions.toOrderEntity
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.CreateOrderUsecase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.net.URI

@Component
class OrderHandler(
    private val createOrderUsecase: CreateOrderUsecase
) {

    companion object { const val ORDER_API = "/api/orders" }

    fun create(serverRequest: ServerRequest) =
        serverRequest.bodyToMono(OrderRequest::class.java)
            .flatMap {
                ServerResponse.created(URI(ORDER_API))
                    .body(createOrderUsecase.create(it.toOrderEntity()), OrderEntity::class.java)
            }

    fun getById(serverRequest: ServerRequest):  Mono<ServerResponse> =
        ServerResponse
            .ok()
            .body(
                Mono.just(OrderEntity(id = serverRequest.pathVariable("id"))),
                OrderEntity::class.java
            )
}