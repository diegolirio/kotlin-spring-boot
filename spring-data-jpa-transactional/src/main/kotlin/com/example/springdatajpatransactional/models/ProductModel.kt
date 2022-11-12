package com.example.springdatajpatransactional.models

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
data class ProductModel(

    @Id @GeneratedValue
    val id: Long? = null,
    val price: BigDecimal? = null,
    val description: String? = null

)