package com.example.demovaultgradlekotlin

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RestController

@RestController
class VaultRestController {

    @Value("\${kotlin.secret}")
    private lateinit var secret: String

    fun getSectre(): String {
        return this.secret;
    }
}