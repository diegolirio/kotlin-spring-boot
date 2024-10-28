package com.example.kafkaretryanddlq

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaRetryAndDlqApplication

fun main(args: Array<String>) {
	runApplication<KafkaRetryAndDlqApplication>(*args)
}
