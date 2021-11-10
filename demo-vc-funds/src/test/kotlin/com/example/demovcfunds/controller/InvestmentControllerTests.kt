package com.example.demovcfunds.controller

import com.example.demovcfunds.controller.handles.ResponseData
import com.example.demovcfunds.entity.Investment
import com.example.demovcfunds.fixtures.*
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
    fun testCreateInvestmentLogTechSectorNotAllowedToInvest() {
        val investment = getInvestmentFinTechLogTechSector()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Sector not allowed to invest", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValuationInvalid() {
        val investment = getInvestmentFinTechWithValuation500ThousandDollars()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 million dollars", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechOperationTimeInvalidForValuation10to15millions() {
        val investment = getInvestmentFinTech2MounthsAgo()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("FinTech should be operating for more than 2 years for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidLteForValuation10to15millions() {
        val investment = getInvestmentFinTechWithValueToInvest19DollarsAnd90Cents()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Value to invest should be between 500 thousand to 2 million dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidGteForValuation10to15millions() {
        val investment = getInvestmentFinTechValueToInvest2millions999Thousand19Dolars90Cents()
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Value to invest should be between 500 thousand to 2 million dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValidWithValuation10to15millions() {
        val investment = getInvestmentFinTechValidWithValuationBetween10to15millions()
        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        Assertions.assertEquals(200, response.statusCodeValue)
        Assertions.assertNotNull(response.body!!.id)
    }

    /**
     * Senarios de Testes
     *
     * 1. OK - Sector Not Allwed to Invest
     *
     * 2. OK - FinTech :: Valuation Not Allowed for FinTech, valuation should be between 10 to 60 million dollars
     *
     * 3. OK - FinTech :: Operating Time :: FinTech should be operating for more than 2 years for this Valuation
     * 4. OK - FinTech :: Value to Invest :: Value to invest should be between 500 thousand to 2 million dollars for this valuation
     * 5. OK - FinTech :: OK - Successful Investment
     *
     * 5. FinTech :: Operating Time :: Startup will should to be operating to more 2 years for this valuation
     * 6. FinTech :: Value to Invest :: Value to invest will should to be above 2 to 6 millions dollars for this valuation
     * 5. FinTech :: Successful Investment
     *
     * 7. FinTech :: Operating Time :: Startup will should to be operating to more 3 years for this valuation
     * 8. FinTech :: Value to Invest :: Value to invest will should to be above 6 to 10 millions dollars for this valuation
     * 9. FinTech :: Investment saved with success!!!
     *
     * 9. HealthTech :: Valuation Not Allowed, only between 600 thousant to 6 millions of dollars
     * 10. HealthTech :: Operating Time :: Startup will should to be operating to more 1 year for this valuation
     * 11. HealthTech :: Value to Invest :: Value to invest will should to be between 200 thousant to 600 thousant dollars for this valuation
     * 12. HealthTech :: Operating Time :: Startup will should to be operating to more 2 years for this valuation
     * 13. HealthTech :: Value to Invest :: Value to invest will should to be above 600 thounsat to 2 millions dollars for this valuation
     * 14. HealthTech :: Operating Time :: Startup will should to be operating to more 3 years for this valuation
     * 15. HealthTech :: Value to Invest :: Value to invest will should to be above 1 to 3 millions dollars for this valuation
     * 9. HealthTech :: Investment saved with success!!!
     * 16. FoodTech :: Valuation Not Allowed, only between 10 to 60 millions of dollars
     * 17. FoodTech :: Operating Time :: Startup will should to be operating to more 1 year for this valuation
     * 18. FoodTech :: Value to Invest :: Value to invest will should to be between 1 to 2.5 millions dollars for this valuation
     * 19. FoodTech :: Operating Time :: Startup will should to be operating to more 2 years for this valuation
     * 20. FoodTech :: Value to Invest :: Value to invest will should to be above 2 to 5 millions dollars for this valuation
     * 21. FoodTech :: Operating Time :: Startup will should to be operating to more 3 years for this valuation
     * 22. FoodTech :: Value to Invest :: Value to invest will should to be above 4 to 8 millions dollars for this valuation
     * 9. FoodTech :: Investment saved with success!!!
     */

    @Test
    fun testCreateInvestmentFinTechOperationTimeInvalidForValuation15to40millions() {
        val investment = Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 1000999.0,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusYears(1)
        )
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("FinTech should be operating for more than 2 years for this Valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidLteForValuation15to40millions() {
        val investment = Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 15000000.00,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(30)
        )
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Value to invest should be between 500 thousand to 2 million dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValueToInvestInvalidGteForValuation15to40millions() {
        val investment = Investment(
                companyCnpj = "95504515000135",
                companyName = "Devspoint",
                value = 2999019.90,
                companyValuation = 21000000.0,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(15)
        )
        val response = restTemplate.postForEntity("/investments", investment, ResponseData::class.java)
        Assertions.assertEquals(412, response.statusCodeValue)
        Assertions.assertEquals("Value to invest should be between 500 thousand to 2 million dollars for this valuation", response.body!!.message)
    }

    @Test
    fun testCreateInvestmentFinTechValidWithValuation15to40millions() {
        val investment = Investment(
                companyCnpj = "1",
                companyName = "Devspoint",
                value = 500999.0,
                companyValuation = 21000000.0,
                id = null,
                sector = Investment.SectorEnum.FINTECH,
                startDate = LocalDate.now().minusMonths(13)
        )

        val response = restTemplate.postForEntity("/investments", investment, Investment::class.java)
        Assertions.assertEquals(200, response.statusCodeValue)
        Assertions.assertNotNull(response.body!!.id)
    }

}