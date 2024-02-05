package com.example.demoreativespring3java21.usecase

import com.example.demoreativespring3java21.entity.PositionEntity
import com.example.demoreativespring3java21.providers.oracle.repository.PositionRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class PositionUsecase(
        private val positionRepository: PositionRepository
) {

    fun get(): Flux<PositionEntity> {
        return positionRepository.findAll()
        //return Flux.just(PositionEntity(1, BigDecimal.ONE))
    }

}
