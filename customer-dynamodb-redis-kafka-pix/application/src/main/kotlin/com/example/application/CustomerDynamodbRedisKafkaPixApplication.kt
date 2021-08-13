package com.example.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerDynamodbRedisKafkaPixApplication

fun main(args: Array<String>) {
	runApplication<CustomerDynamodbRedisKafkaPixApplication>(*args)
}