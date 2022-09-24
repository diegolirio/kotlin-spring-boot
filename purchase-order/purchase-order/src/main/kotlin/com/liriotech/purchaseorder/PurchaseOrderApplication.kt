package com.liriotech.purchaseorder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class PurchaseOrderApplication

fun main(args: Array<String>) {
	runApplication<PurchaseOrderApplication>(args = args)
}
