package com.liriotech.purchaseorder.domain.usecases

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import reactor.core.publisher.Mono
import java.util.*
import javax.inject.Named

@Named
class CreateOrderUsecase {

    fun create(order: OrderEntity) : Mono<OrderEntity> {
        order.id = UUID.randomUUID().toString()
        return Mono.just(order)
    }


}
