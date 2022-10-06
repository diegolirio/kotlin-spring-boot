package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono

class ValidateOrderStep : OrderStepExecution<OrderEntity> {

    private val log = LoggerFactory.getLogger(this::class.java)
    override fun doExec(input: Mono<OrderEntity>): Mono<OrderEntity> {
        log.info("m=doExec, message=starting")
        return input.map {
            if(it.customerId == null) {
                throw StopStepExecption("Customer is required")
            }
            log.info("m=doExec, message=finished")
            it
        }
    }

//    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> {
//        log.info("m=doExec, message=starting")
//        if(input.payload.customerId == null) {
//            throw StopStepExecption("Customer is required")
//        }
//        log.info("m=doExec, message=finished")
//        return input
//    }

}
