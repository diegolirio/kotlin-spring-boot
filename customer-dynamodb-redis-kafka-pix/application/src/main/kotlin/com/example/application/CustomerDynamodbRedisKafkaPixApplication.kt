package com.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class CustomerDynamodbRedisKafkaPixApplication

fun main(args: Array<String>) {
	runApplication<CustomerDynamodbRedisKafkaPixApplication>(*args)
}
