package com.example.demovcfunds.service

import com.example.demovcfunds.controller.handles.exceptions.OperatingTimeInvalidException
import com.example.demovcfunds.controller.handles.exceptions.ValuationInvalidException
import com.example.demovcfunds.controller.handles.exceptions.ValueToInvestInvalidException
import com.example.demovcfunds.entity.Investment
import com.example.demovcfunds.repository.InvestmentRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.LocalDate

@Service
class InvestmentService(
        private val investmentRepository: InvestmentRepository
) {

    fun save(investment: Investment): Investment {
        // FINTECH
        if(investment.sector == Investment.SectorEnum.FINTECH) {
            if(investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    if(investment.value >= 500000 && investment.value <= 2000000) {
                        return investmentRepository.save(investment)
                    }
                    throw ValueToInvestInvalidException("Value to invest should be between 500 thousand to 2 million dollars for this valuation")
                }
                throw OperatingTimeInvalidException("FinTech should be operating for more than 2 years for this Valuation")
            }
            if(investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 2000000 && investment.value <= 6000000) {
                        return investmentRepository.save(investment)
                    }
                    throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes somente poderá ter aportes entre 500 mil e 2 milhoes")
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 2 anos de operação")
            }
            if(investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                    if(investment.value >= 6000000 && investment.value <= 10000000) {
                        return investmentRepository.save(investment)
                    }
                    throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes somente poderá ter aportes entre 500 mil e 2 milhoes")
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 3 anos de operação")
            }
            throw ValuationInvalidException("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 million dollars")
        }
        // HEALTHTECH
        if(investment.sector == Investment.SectorEnum.HEALTHTECH) {
            if(investment.companyValuation >= 6000000 && investment.companyValuation <= 10000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    if(investment.value >= 200000 && investment.value <= 600000) {
                        return investmentRepository.save(investment)
                    }
                    throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes somente poderá ter aportes entre 500 mil e 2 milhoes")
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 1 ano de operação")
            }
            if(investment.companyValuation > 10000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 600000 && investment.value <= 2000000) {
                        return investmentRepository.save(investment)
                    }
                    throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes somente poderá ter aportes entre 500 mil e 2 milhoes")
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 2 anos de operação")
            }
            if(investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 1000000 && investment.value <= 3000000) {
                        return investmentRepository.save(investment)
                    }
                    throw RuntimeException("Fintech com Valuation entre 1 milhao e 3 milhoes somente poderá ter aportes entre 500 mil e 2 milhoes")
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 3 anos de operação")
            }
            throw RuntimeException("Valuation invalido para FINTECH, valor deverá estar entre 10 milhoes a 60 milhoes")
        }
        // FOODTECH
        if(investment.sector == Investment.SectorEnum.FOODTECH) {
            if(investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    return investmentRepository.save(investment)
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 1 ano de operação")
            }
            if(investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    return investmentRepository.save(investment)
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 2 anos de operação")
            }
            if(investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                    return investmentRepository.save(investment)
                }
                throw RuntimeException("Fintech com Valuation entre 10 milhoes e 15 milhoes deverá ter mais de 3 anos de operação")
            }
            throw RuntimeException("Valuation invalido para FINTECH, valor deverá estar entre 10 milhoes a 60 milhoes")
        }
        throw IllegalArgumentException("Sector not allowed to invest")
    }


}
