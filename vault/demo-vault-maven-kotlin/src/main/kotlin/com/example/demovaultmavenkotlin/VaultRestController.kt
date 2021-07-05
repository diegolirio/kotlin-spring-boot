package com.example.demovaultmavenkotlin

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VaultRestController {

    @Value("\${kotlin.secret}")
    private lateinit var secret: String

    @GetMapping
    fun getSectre(): String {
        return this.secret;
    }
}