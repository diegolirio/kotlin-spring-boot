package com.liriotech.purchaseorder.domain.usecases.create.workflow.steps

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.entities.StatusEnum
import com.liriotech.purchaseorder.domain.providers.CreateOrderProvider
import com.liriotech.purchaseorder.domain.usecases.create.workflow.OrderStepExecution
import reactor.core.publisher.Mono

class CreateOrderStep(
    private val provider: CreateOrderProvider
) : OrderStepExecution<OrderEntity> {

//    override fun doExec(input: ContextPayload<OrderEntity>): ContextPayload<OrderEntity> {
//        return input.payload.copy(status = StatusEnum.PENDING)
//            .run {
//                provider
//                    .create(this)
//                    .subscribe {
//                        ContextPayload(it)
//                    }
//            }
//    }

    //        val run = input.payload.copy(status = StatusEnum.PENDING)
//            .run {
//                //ContextPayload(this)
//                provider
//                    .create(this)
//                    .map {
//                        ContextPayload(it)
//                    }
//            }
//        return run.block()!!
    override fun doExec(input: Mono<OrderEntity>): Mono<OrderEntity> {
        return input.flatMap {
            it.copy(status = StatusEnum.PENDING)
                .run {
                    //ContextPayload(this)
                    provider
                        .create(this)
                }
        }
    }

}
