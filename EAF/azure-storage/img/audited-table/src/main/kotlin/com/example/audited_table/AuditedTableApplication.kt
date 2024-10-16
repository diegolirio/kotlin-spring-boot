package com.example.audited_table

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuditedTableApplication

fun main(args: Array<String>) {
	runApplication<AuditedTableApplication>(*args)
}
