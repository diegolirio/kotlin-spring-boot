package com.example.demovcfunds.entity

import java.time.LocalDate

data class Investment(
        var id: String? = null,
        var companyCnpj: String? = null,
        var companyName: String? = null,
        var companyValuation: Double = 0.0.toDouble(),
        var sector: SectorEnum? = null,
        var value: Double = 0.0.toDouble(),
        var startDate: LocalDate? = null
) {
    enum class SectorEnum {
        FINTECH, HEALTHTECH, FOODTECH, RETAILTECH, AGTECH, LOGTECH, MARTECH
    }
}
