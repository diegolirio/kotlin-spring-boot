package com.example.demoreativespring3java21.providers.oracle.repository

import com.example.demoreativespring3java21.entity.PositionEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PositionRepository : ReactiveCrudRepository<PositionEntity, Long> {
}