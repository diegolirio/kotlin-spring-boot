package com.example.ktlint.presenters.routes

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerRoute {
    @GetMapping
    fun getAll(): List<String> = listOf()
}
