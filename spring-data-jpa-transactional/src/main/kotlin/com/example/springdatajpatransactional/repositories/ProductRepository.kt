package com.example.springdatajpatransactional.repositories

import com.example.springdatajpatransactional.models.ProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<ProductModel, Long>
