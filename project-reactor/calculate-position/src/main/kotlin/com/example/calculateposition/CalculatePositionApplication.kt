package com.example.calculateposition

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class CalculatePositionApplication

fun main(args: Array<String>) {
	runApplication<CalculatePositionApplication>(*args)
}

@Component
class Init(
	private val usecase: CustodyUsecase
) : CommandLineRunner {


	override fun run(vararg args: String?) {
		println("run")
		usecase.findAll()
			.doOnComplete {
				println("doOnComplete")
			}
			.subscribe()

	}

}
