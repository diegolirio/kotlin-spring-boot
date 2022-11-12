package com.example.springdatajpatransactional.repositories

import com.example.springdatajpatransactional.models.AddressModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<AddressModel, Long>
