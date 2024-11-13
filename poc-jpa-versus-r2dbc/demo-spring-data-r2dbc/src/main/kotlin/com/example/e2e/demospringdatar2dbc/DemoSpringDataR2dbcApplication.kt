package com.example.e2e.demospringdatar2dbc

import com.example.e2e.demospringdatar2dbc.entity.CustodyEntity
import com.example.e2e.demospringdatar2dbc.service.CustodyService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.*

@SpringBootApplication
class DemoSpringDataR2dbcApplication

fun main(args: Array<String>) {
    runApplication<DemoSpringDataR2dbcApplication>(*args)
}

@Component
class InitCommandLineRunner(
        private val custodyService: CustodyService
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String) {
        log.info("Executing CommandLineRunner")
        val insertPosition = false
        if (insertPosition) {
            insertPositions()
        } else {
            custodyService.updatePositions()
        }
    }

    private fun insertPositions() {

		val start = System.currentTimeMillis()

        custodyService.count()
                .flatMap { count ->

                    log.info("Count on DB = $count")

                    val listToInsert = generateList(count)
                    if (listToInsert.size > 0) {
                        custodyService.saveAll(listToInsert)
                                .onErrorResume { error ->
                                    log.error("Error occurred during save: {}", error)
                                    Mono.empty()
                                }.subscribe(
									{ count ->
										log.info("FINISHED")
									},
									{ error ->
										log.error("An error occurred: {}", error)
									}
								)
                    } else {
                        log.warn("There is no register to insert")
                    }
                    Mono.just(count)

//					if (count <= COUNT_TO_INSERT) {
//						Flux.range(1, COUNT_TO_INSERT - count.toInt())
//								.flatMap { _ ->
//									CustodyEntity(customerId = UUID.randomUUID().toString())
//									custodyService.save(CustodyEntity(customerId = UUID.randomUUID().toString()))
//											.onErrorResume { error ->
//												log.error("Error occurred during save: {}", error)
//												Mono.empty()
//											}
//								}
//								.then(Mono.just(count))
//					} else {
//						Mono.empty()
//					}
                }
                .doOnError { error ->
                    log.error("Error occurred: {}", error)
                }.subscribe(
                        { count ->
                            log.info("CommandLineRunner finished, count=$count, elapsed=${(System.currentTimeMillis() - start) / 1000} sec")
                        },
                        { error ->
                            log.error("An error occurred: {}", error)
                        }
                )
        log.info("NON BLOCKING... executing insert")
    }

    private fun generateList(count: Long): MutableList<CustodyEntity> {
        val list = mutableListOf<CustodyEntity>()
        for (e in 1..COUNT_TO_INSERT - count.toInt()) {
            list.add(CustodyEntity(customerId = UUID.randomUUID().toString()))
        }
        log.warn("Count to Insert = ${list.size}")
        return list
    }

    companion object {
        const val COUNT_TO_INSERT = 11_000_000
    }

}