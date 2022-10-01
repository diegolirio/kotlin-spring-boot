package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LockStep : OrderStepExecution<ContextPayload<OrderEntity>>, LockKey {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> =
        LockProcess.lock(getKey(input), input.payload)
            .let {
                log.info("m=doExec, message=$it")
                if(!it.first) {
                    throw StopStepExecption("Order is already in processing!")
                }
                input
            }


}
