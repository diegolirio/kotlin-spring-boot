package com.example.demoreativespring3java21.entity

import org.springframework.data.annotation.Id
import java.math.BigDecimal

data class PositionEntity(
        @Id
        var id: Long? = null,
        var netValue: BigDecimal? = null
)
