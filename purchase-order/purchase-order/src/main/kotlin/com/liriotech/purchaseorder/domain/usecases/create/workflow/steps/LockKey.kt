package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import reactor.core.publisher.Mono
import java.util.Base64

interface LockKey {

    fun getKey(input: OrderEntity) : String =
        Base64.getEncoder()
            .encodeToString(
                (input.customerId + input.productCode + input.value).toByteArray()
            )


}