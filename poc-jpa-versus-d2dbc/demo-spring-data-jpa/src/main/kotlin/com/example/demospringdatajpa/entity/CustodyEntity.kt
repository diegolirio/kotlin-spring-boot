package com.example.demospringdatajpa.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "CUSTODY")
data class CustodyEntity(
        @Id @GeneratedValue
        var id: Long? = null,

        var customerId: String? = null
)
