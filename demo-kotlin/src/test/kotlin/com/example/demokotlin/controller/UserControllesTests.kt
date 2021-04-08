package com.example.demokotlin.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class UserControllesTests {

    @Autowired
    private lateinit var userController: UsersController

    @Test
    fun `test get all users`() {
        val client = WebTestClient.bindToController(userController).build()
        client.get()
            .uri("/users")
            .exchange()
            .expectBody()
            .json("[]")
    }
}