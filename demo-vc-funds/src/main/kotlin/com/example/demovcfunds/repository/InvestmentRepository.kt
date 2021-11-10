package com.example.demovcfunds.repository

import com.example.demovcfunds.entity.Investment
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class InvestmentRepository {
    fun save(investment: Investment): Investment {
        investment.id = UUID.randomUUID().toString()
        return investment
    }

}
