package com.lirio.fixed.income.pricing.usecase

import java.math.BigDecimal

data class SimulationRequest(
    val value: BigDecimal,
    val cdiRate: BigDecimal
)
