package com.lirio.fixed.income.pricing.usecase

import java.math.BigDecimal

data class PrincingResponse(
    val netRedemptionValue: BigDecimal,
    val grossRedemptionValue: BigDecimal,
    val iofValue: BigDecimal,
    val irValue: BigDecimal,
)
