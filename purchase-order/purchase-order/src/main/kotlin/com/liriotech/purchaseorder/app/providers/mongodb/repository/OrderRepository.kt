package com.liriotech.purchaseorder.app.providers.mongodb.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : ReactiveMongoRepository<Order, String>
