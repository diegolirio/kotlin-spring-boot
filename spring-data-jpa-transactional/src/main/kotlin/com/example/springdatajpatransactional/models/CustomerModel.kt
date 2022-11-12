package com.example.springdatajpatransactional.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "customer")
data class CustomerModel(

    @Id @GeneratedValue
    val id: Long? = null,
    val cpfCnpj: String? = null,
    val name: String? = null,
    @OneToMany(mappedBy = "customer")
    val addresses: List<AddressModel>? = null
)