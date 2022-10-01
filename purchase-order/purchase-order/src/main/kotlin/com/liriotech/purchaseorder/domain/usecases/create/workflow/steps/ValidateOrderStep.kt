package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption
import org.slf4j.LoggerFactory

class ValidateOrderStep : OrderStepExecution<ContextPayload<OrderEntity>> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> {
        log.info("m=doExec, message=starting")
        if(input.payload.customerId == null) {
            throw StopStepExecption("Customer is required")
        }
        log.info("m=doExec, message=finished")
        return input
    }

}
