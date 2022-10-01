package com.liriotech.purchaseorder.domain.usecases.create

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.CreateOrderProvider
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderExecutorChain
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.*
import reactor.core.publisher.Mono
import javax.inject.Named

@Named
class CreateOrderUsecase(
    private val createOrderProvider: CreateOrderProvider,
    private val notifyChangesProvider: NotifyChangesProvider,

) {

    fun create(orderEntity: OrderEntity) : Mono<OrderEntity> =
        OrderExecutorChain
            .begin(LockStep())
            .and(ValidateOrderStep())
            .and(CreateOrderStep(createOrderProvider))
            .and(NotifyChangesStep(notifyChangesProvider))
            .doFinally(UnlockStep())
            .apply(ContextPayload(orderEntity))
            .let { Mono.just(it.payload) }

}
