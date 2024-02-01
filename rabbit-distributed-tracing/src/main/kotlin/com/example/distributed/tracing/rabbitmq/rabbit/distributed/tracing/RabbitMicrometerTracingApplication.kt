package com.example.distributed.tracing.rabbitmq.rabbit.distributed.tracing

import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RabbitMicrometerTracingApplication

fun main(args: Array<String>) {
	runApplication<RabbitMicrometerTracingApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}

@Component
class CommandLineApp : CommandLineRunner {

	private val log = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String?) {
		log.info("Hello, command-line runner!")
	}
}

@RestController
class CustomerHttpController {

	private val log = LoggerFactory.getLogger(javaClass)

	@GetMapping
	fun send(): List<String> {
		return listOf("Diego Lirio").also {
			log.info(it.toString())
		}
	}

}
