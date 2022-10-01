package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import com.liriotech.purchaseorder.domain.usecases.create.workflow.steps.exception.StopStepExecption

class UnlockStep : OrderStepExecution<ContextPayload<OrderEntity>>, LockKey {

    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> {
        if(LockProcess.validate(getKey(input))) {
            LockProcess.unlock(
                key = getKey(input),
                clazz = OrderEntity::class.java
            ).let {
                if(it.first && !LockProcess.validate(getKey(input))) {
                    return input
                }
                throw StopStepExecption("It was not possible to remove order in processing")
            }
        } else {
            throw StopStepExecption("Order is not processing")
        }
    }

}
