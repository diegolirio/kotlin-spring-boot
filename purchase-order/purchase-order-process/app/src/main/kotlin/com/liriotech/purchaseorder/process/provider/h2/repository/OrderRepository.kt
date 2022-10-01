package com.liriotech.purchaseorder.process.provider.h2.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<OrderModel, Long>