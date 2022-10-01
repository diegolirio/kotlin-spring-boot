package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution

class NotifyChangesStep(
    private val notifyChangesProvider: NotifyChangesProvider
) : OrderStepExecution<ContextPayload<OrderEntity>> {

    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> =
        notifyChangesProvider
            .send(input.payload)
            .let { input }

}
