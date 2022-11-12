package com.example.springdatajpatransactional.models

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "order_product")
data class OrderProductModel(

    @Id @GeneratedValue
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val productModel: ProductModel? = null,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val orderModel: OrderModel,

    val amount: Int? = null,

    val price: BigDecimal? = null

)