package com.liriotech.purchaseorder.process.providers

import com.liriotech.purchaseorder.process.entities.OrderEntity

interface CreateOrderProcessProvider {
    fun create(orderEntity: OrderEntity): OrderEntity
}