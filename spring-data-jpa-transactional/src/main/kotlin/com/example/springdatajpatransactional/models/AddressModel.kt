package com.example.springdatajpatransactional.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="address")
data class AddressModel(

    @Id @GeneratedValue
    val id: Long? = null,

    val description: String? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    val customer: CustomerModel? = null

)