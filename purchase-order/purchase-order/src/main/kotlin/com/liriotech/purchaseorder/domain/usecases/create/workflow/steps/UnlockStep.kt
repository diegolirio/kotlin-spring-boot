package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption
import reactor.core.publisher.Mono

class UnlockStep : OrderStepExecution<OrderEntity>, LockKey {

    override fun doExec(input: Mono<OrderEntity>): Mono<OrderEntity> =
        input.map {
            if(!LockProcess.validate(getKey(it))) {
                throw StopStepExecption("Order is not processing")
            }
            LockProcess.unlock(
                key = getKey(it),
                clazz = OrderEntity::class.java
            ).let { result ->
                if(!result.first || LockProcess.validate(getKey(it))) {
                    throw StopStepExecption("It was not possible to remove order in processing")
                }
                it
            }
        }

}
