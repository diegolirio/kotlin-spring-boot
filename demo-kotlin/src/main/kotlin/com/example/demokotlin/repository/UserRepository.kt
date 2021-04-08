package com.example.demokotlin.repository

import com.example.demokotlin.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: ReactiveMongoRepository<User, String> {

}
