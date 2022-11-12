package com.example.springdatajpatransactional.repositories

import com.example.springdatajpatransactional.models.OrderProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderProductRepository : JpaRepository<OrderProductModel, Long>
