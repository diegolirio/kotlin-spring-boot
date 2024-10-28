package com.example.testcontainer.core.repository

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class PositionModel(
    @Id @GeneratedValue var id: Long? = null,
    var code: String? = null,
    var quantity: Int? = null,
    var value: Double? = null
) {

}
