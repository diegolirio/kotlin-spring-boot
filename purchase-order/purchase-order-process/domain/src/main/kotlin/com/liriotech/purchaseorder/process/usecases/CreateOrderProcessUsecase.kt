package com.liriotech.purchaseorder.process.usecases

import com.liriotech.purchaseorder.process.entities.OrderEntity
import com.liriotech.purchaseorder.process.providers.CreateOrderProcessProvider
import javax.inject.Named

@Named
class CreateOrderProcessUsecase(
    private val createOrderProcessProvider: CreateOrderProcessProvider
) {

    //private val log = LoggerFactory.getLogger(this::class.java)

    fun create(orderEntity: OrderEntity) : OrderEntity =
        createOrderProcessProvider.create(
            orderEntity
        )


}