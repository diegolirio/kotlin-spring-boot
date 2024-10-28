package com.example.testcontainer.core.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PositionRepository : CrudRepository<PositionModel, Long> {

    fun findByCode(code: String) : PositionModel
}
