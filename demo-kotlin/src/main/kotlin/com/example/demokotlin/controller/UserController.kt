package com.example.demokotlin.controller

import com.example.demokotlin.model.User
import com.example.demokotlin.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class UsersController(
    private val userService: UserService
) {

    @GetMapping("/users")
    fun getAll(): Flux<User> {
        return userService.getAll()
    }
}

