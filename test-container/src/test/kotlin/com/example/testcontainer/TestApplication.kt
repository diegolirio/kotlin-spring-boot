package com.example.testcontainer

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.KafkaContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestTestContainerApplication {

	@Bean
	@ServiceConnection
	fun kafkaContainer(): KafkaContainer {
		return KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"))
	}

}

fun main(args: Array<String>) {
	fromApplication<Application>().with(TestTestContainerApplication::class).run(*args)
}
