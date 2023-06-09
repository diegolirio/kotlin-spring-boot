package com.example.democacheabstraction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class DemoCacheAbstractionApplication

fun main(args: Array<String>) {
	runApplication<DemoCacheAbstractionApplication>(*args)
}
