package io.github.diegolirio.userimc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserImcApplication

fun main(args: Array<String>) {
	runApplication<UserImcApplication>(*args)
}
