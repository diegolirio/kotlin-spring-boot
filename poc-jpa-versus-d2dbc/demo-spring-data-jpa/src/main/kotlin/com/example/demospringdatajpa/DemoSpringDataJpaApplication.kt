package com.example.demospringdatajpa

import com.example.demospringdatajpa.service.CustodyService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoSpringDataJpaApplication

fun main(args: Array<String>) {
	runApplication<DemoSpringDataJpaApplication>(*args)
}

@Component
class InitCommandLineRunner(
		private val custodyService: CustodyService
) : CommandLineRunner {

	private val log = LoggerFactory.getLogger(javaClass)

	override fun run(vararg args: String) {

//		log.info("Executing CommandLineRunner")
//		var start = System.currentTimeMillis()
//		var size = custodyService.updatePositionsNoPaged()
//		log.info("CommandLineRunner finished, size=$size, elapsed=${(System.currentTimeMillis() - start)} ms")

		log.info("Executing CommandLineRunner")
		var start = System.currentTimeMillis()
		var size = custodyService.updatePositionsPaged()
		log.info("CommandLineRunner finished, size=$size, elapsed=${(System.currentTimeMillis() - start)} ms")

	}

}