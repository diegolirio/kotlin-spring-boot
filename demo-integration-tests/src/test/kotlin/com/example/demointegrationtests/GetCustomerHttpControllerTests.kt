package com.example.demointegrationtests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(classes = [DemoIntegrationTestsApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetCustomerHttpControllerTests {

    @Autowired private lateinit var restTemplate: TestRestTemplate
    @Autowired private lateinit var repository: CustomerRepository

    @Test
    fun test() {

        repository.save(Customer())

        restTemplate
            .getForEntity("/v1/customers", List::class.java)
            .let {
                println(it.body)
                Assertions.assertEquals(HttpStatus.OK, it.statusCode)
                Assertions.assertEquals(1, it.body!!.size)
            }
    }

}