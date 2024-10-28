package com.example.testcontainer.app.controller

import com.example.testcontainer.Application
import com.example.testcontainer.core.repository.PositionRepository
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Import(ApplicationTests::class)
@ActiveProfiles("test")
class CustodyRestControllerTests {

    @Autowired private lateinit var restTemplate: TestRestTemplate
    @Autowired private lateinit var positionRepository: PositionRepository

    @Test
    fun `should be return http status 200 to be considered the position conciliation OK`() {
        val code = UUID.randomUUID().toString()
        restTemplate.exchange(
            "/custody-conciliation/$code",
            HttpMethod.POST,
            null,
            object : ParameterizedTypeReference<String>() {}
        ).let {
            println(it.body)
            Assert.assertEquals(HttpStatus.OK, it.statusCode)
//            assertTrue(it.body!!.content.isNotEmpty())
//            assertFalse(it.body!!.last)
//            assertTrue(it.body!!.first)
//            assertFalse(it.body!!.empty)
//            assertEquals(5, it.body!!.totalPages)
//            assertEquals(50, it.body!!.totalElements)
//            assertEquals(10, it.body!!.pageSize)
//            assertEquals(0, it.body!!.pageNumber)
        }
    }

}