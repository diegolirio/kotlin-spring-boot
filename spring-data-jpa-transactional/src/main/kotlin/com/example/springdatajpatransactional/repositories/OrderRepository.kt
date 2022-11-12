package com.example.springdatajpatransactional.repositories

import com.example.springdatajpatransactional.models.OrderModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<OrderModel, Long>
