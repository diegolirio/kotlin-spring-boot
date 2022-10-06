package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

class LockStep : OrderStepExecution<OrderEntity>, LockKey {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun doExec(input: Mono<OrderEntity>): Mono<OrderEntity> =
        input.map {
            LockProcess.lock(getKey(it), it)
                .let { pair ->
                    log.info("m=doExec, message=$it")
                    if (!pair.first) {
                        throw StopStepExecption("Order is already in processing!")
                    }
                }
            it
        }
}
