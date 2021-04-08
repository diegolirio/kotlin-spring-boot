package com.example.demokotlin.service

import com.example.demokotlin.model.User
import com.example.demokotlin.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getAll(): Flux<User> {
        return userRepository.findAll()
    }
}