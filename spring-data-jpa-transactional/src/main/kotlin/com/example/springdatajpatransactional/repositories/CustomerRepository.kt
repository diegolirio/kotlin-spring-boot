package com.example.springdatajpatransactional.repositories

import com.example.springdatajpatransactional.models.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerModel, Long>
