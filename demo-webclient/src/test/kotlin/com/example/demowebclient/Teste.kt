package com.example.demowebclient

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Profile("test")
@ActiveProfiles("test")
class Teste {

    @Autowired
    private val webTestClient: WebTestClient? = null

    @Test
    fun testHelloName() {
        val name = "Diego"
        webTestClient!!.get().uri("/hello?name=$name")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String::class.java).isEqualTo("Hello, $name!")
    }

    @Test
    fun testHelloWorld() {
        webTestClient!!.get().uri("/hello")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String::class.java).isEqualTo("Hello, world!")
    }

    @Test
    fun testHelloNamePathVar() {
        val name = "Taina"
        webTestClient!!.get().uri("/hello/$name")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String::class.java).isEqualTo("Hello, $name!")
    }

    fun stubProvider() {
        // /hello/?name=Diego
    }
}