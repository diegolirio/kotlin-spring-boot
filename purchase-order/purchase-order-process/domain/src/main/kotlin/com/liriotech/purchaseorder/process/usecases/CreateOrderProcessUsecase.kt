package com.liriotech.purchaseorder.process.usecases

import com.liriotech.purchaseorder.process.entities.OrderEntity
import javax.inject.Named

@Named
class CreateOrderProcessUsecase {

    //private val log = LoggerFactory.getLogger(this::class.java)

    fun create(orderEntity: OrderEntity) {
        println(orderEntity)
    }

}