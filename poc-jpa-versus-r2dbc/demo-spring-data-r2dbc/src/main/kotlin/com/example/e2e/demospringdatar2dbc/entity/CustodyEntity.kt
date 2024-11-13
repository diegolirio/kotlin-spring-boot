package com.example.e2e.demospringdatar2dbc.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("custody")
data class CustodyEntity(
        @Id
        @Column("ID")
        var id: Long? = null,

        @Column("CUSTOMER_ID")
        var customerId: String? = null
)
