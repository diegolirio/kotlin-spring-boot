package com.liriotech.purchaseorder.domain.usecases

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.entities.StatusEnum
import com.liriotech.purchaseorder.domain.providers.CreateOrderProvider
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import reactor.core.publisher.Mono
import java.util.*
import javax.inject.Named

@Named
class CreateOrderUsecase(
    private val createOrderProvider: CreateOrderProvider,
    private val notifyChangesProvider: NotifyChangesProvider
) {

    fun create(orderEntity: OrderEntity) : Mono<OrderEntity> =
         createOrderProvider
             // lock
             // validates (chain)
             .create(
                 orderEntity.copy(status = StatusEnum.PENDING)
             )
             .flatMap {
                 // unlock
                 notifyChangesProvider.send(it)
                 Mono.just(it)
             }


}
