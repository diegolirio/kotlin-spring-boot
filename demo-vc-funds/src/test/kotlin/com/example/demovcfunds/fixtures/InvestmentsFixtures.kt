package com.example.demovcfunds.fixtures

import com.example.demovcfunds.entity.Investment
import java.time.LocalDate

fun getInvestmentFinTechLogTechSector() =
     Investment(
        companyCnpj = "95504515000135",
        companyName = "Devspoint",
        value = 500999.0,
        companyValuation = 11000000.0,
        sector = Investment.SectorEnum.LOGTECH,
        startDate = LocalDate.of(2019,3,5)
    )

fun getInvestmentFinTechWithValuation500ThousandDollars() =
    Investment(
        companyCnpj = "95504515000135",
        companyName = "Devspoint",
        value = 500000.0,
        companyValuation = 100777.0,
        sector = Investment.SectorEnum.FINTECH,
        startDate = LocalDate.of(2019,3,5)
    )

fun getInvestmentFinTech2MounthsAgo() =
    Investment(
        companyCnpj = "95504515000135",
        companyName = "Devspoint",
        value = 1000999.0,
        companyValuation = 10100777.0,
        sector = Investment.SectorEnum.FINTECH,
        startDate = LocalDate.now().minusMonths(2)
    )

fun getInvestmentFinTechWithValueToInvest19DollarsAnd90Cents() =
    Investment(
        companyCnpj = "95504515000135",
        companyName = "Devspoint",
        value = 19.90,
        companyValuation = 10100777.0,
        sector = Investment.SectorEnum.FINTECH,
        startDate = LocalDate.now().minusMonths(15)
    )

fun getInvestmentFinTechValueToInvest2millions999Thousand19Dolars90Cents() =
    Investment(
        companyCnpj = "95504515000135",
        companyName = "Devspoint",
        value = 2999019.90,
        companyValuation = 10100777.0,
        sector = Investment.SectorEnum.FINTECH,
        startDate = LocalDate.now().minusMonths(15)
    )

fun getInvestmentFinTechValidWithValuationBetween10to15millions() =
    Investment(
        companyCnpj = "1",
        companyName = "Devspoint",
        value = 500999.0,
        companyValuation = 11000000.0,
        id = null,
        sector = Investment.SectorEnum.FINTECH,
        startDate = LocalDate.now().minusMonths(13)
    )