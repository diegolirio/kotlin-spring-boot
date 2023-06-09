package com.example.democacheabstraction.client

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class LoginClient {

    @Cacheable("token")
    fun login(clientId: String, clientSecret: String) : String {
        return "${LocalDateTime.now()}--$clientId--$clientSecret"
    }
}