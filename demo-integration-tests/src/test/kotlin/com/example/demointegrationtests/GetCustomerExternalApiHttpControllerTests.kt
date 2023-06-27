package com.example.demointegrationtests

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.common.Json
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = [DemoIntegrationTestsApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class GetCustomerExternalApiHttpControllerTests {

    @Autowired private lateinit var restTemplate: TestRestTemplate

    var wireMockServer: WireMockServer = WireMockServer(8081)

    @BeforeEach
    private fun before() {
        wireMockServer.start()
        stubCustomerExternal()
    }

    @AfterEach
    private fun after() {
        wireMockServer.stop()
    }

    @Test
    fun test_get_external() {
        restTemplate
            .getForEntity("/v2/customers/external", Any::class.java)
            .let {
                Assertions.assertEquals(HttpStatus.OK, it.statusCode)
            }
    }

    private fun stubCustomerExternal() {
        wireMockServer.stubFor(
            WireMock.get(WireMock.urlEqualTo("/external"))
                .willReturn(
                    WireMock.aResponse()
                    .withHeader("Content-Type", "application/json")
                    .withBody(Json.write(listOf( Customer(1))))
                )
        )
    }
}