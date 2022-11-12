package com.example.springdatajpatransactional.models

import EntityPatternModel
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "order")
data class OrderModel(

    @Id @GeneratedValue
    val id: Long? = null,

    val total: BigDecimal? = null,

    @OneToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

) : EntityPatternModel()