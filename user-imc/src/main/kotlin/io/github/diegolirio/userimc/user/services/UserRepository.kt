package io.github.diegolirio.userimc.user.services

import io.github.diegolirio.userimc.user.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {

}
