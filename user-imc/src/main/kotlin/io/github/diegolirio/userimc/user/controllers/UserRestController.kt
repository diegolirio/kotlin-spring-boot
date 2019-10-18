package io.github.diegolirio.userimc.user.controllers

import io.github.diegolirio.userimc.user.domain.User
import io.github.diegolirio.userimc.user.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserRestController(private val userService: UserService) {

    @GetMapping
    fun getAll(): MutableIterable<User> {
        return this.userService.findAll()
    }

    @PostMapping
    fun save(@RequestBody user: User): User {
        return this.userService.save(user)
    }

}
