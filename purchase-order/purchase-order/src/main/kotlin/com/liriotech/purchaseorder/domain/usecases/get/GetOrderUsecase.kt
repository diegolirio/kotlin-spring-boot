package com.liriotech.purchaseorder.domain.usecases.get

import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.GetOrderProvider
import reactor.core.publisher.Flux
import javax.inject.Named

@Named
class GetOrderUsecase(
    private val getOrderProvider: GetOrderProvider
) {

    fun get(): Flux<OrderEntity> = getOrderProvider.get()
}
