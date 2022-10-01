package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.entities.StatusEnum
import com.liriotech.purchaseorder.domain.providers.CreateOrderProvider
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import org.slf4j.LoggerFactory

class CreateOrderStep(
    private val provider: CreateOrderProvider
) : OrderStepExecution<ContextPayload<OrderEntity>> {

    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> =
        input.payload.copy(status = StatusEnum.PENDING)
            .run {
                provider.create(this).let {
                    input // TODO use it to return to method
                }
            }

}
