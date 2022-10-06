package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import reactor.core.publisher.Mono

class NotifyChangesStep(
    private val notifyChangesProvider: NotifyChangesProvider
) : OrderStepExecution<OrderEntity> {

    override fun doExec(input: Mono<OrderEntity>): Mono<OrderEntity> =
        input.map {
            notifyChangesProvider.send(it)
            it
        }

}
