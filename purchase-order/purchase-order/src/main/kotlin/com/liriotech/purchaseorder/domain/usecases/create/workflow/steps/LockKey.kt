package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.usecases.create.workflow.ContextPayload
import java.util.Base64

interface LockKey {

    fun getKey(input: ContextPayload<OrderEntity>) : String =
        Base64.getEncoder().encodeToString(
            (input.payload.customerId + input.payload.productCode + input.payload.value).toByteArray()
        )


}