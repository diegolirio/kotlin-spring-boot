package com.example.demospringdatajpa.repository

import com.example.demospringdatajpa.entity.CustodyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustodyRepository : JpaRepository<CustodyEntity, Long> {

}
