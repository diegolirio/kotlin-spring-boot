package com.example.demovcfunds.controller

import com.example.demovcfunds.controller.handles.ResponseData
import com.example.demovcfunds.entity.Investment
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import java.time.LocalDate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class InvestmentControllerTests {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun createInvestmentLogTechSectorNotAllowedToInvest() {
        val investment = Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 11000000.0,
                id = null,
                sector = Investment.SectorEnum.LOGTECH,
                startDate = LocalDate.of(2019,3,5)
        )

        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Sector not alloed to invest", response.body!!.message)
    }


    @Test
    fun createInvestmentLogTechValuationInvalid() {
        val investment = Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 100777.0,
                id = null,
                sector = Investment.SectorEnum.LOGTECH,
                startDate = LocalDate.of(2019,3,5)
        )

        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Valuation invalido para FINTECH, valor deverá estar entre 10 milhoes a 60 milhoes", response.body!!.message)
    }

    @Test
    fun createInvestmentFinTechValidOne() {
        val investment = Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 11000000.0,
                id = null,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.of(2019,3,5)
        )

        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        Assertions.assertEquals(200, response.statusCodeValue)

    }
}