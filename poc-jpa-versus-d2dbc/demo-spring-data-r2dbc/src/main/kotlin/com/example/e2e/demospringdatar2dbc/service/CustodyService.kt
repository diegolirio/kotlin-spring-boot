package com.example.e2e.demospringdatar2dbc.service

import com.example.e2e.demospringdatar2dbc.entity.CustodyEntity
import com.example.e2e.demospringdatar2dbc.repository.CustodyRepository
import com.example.e2e.demospringdatar2dbc.repository.CustodyRepositoryImpl
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.time.Duration

@Service
class CustodyService(
    private val repository: CustodyRepository,
    private val repositoryImpl: CustodyRepositoryImpl
) {

    private val log = LoggerFactory.getLogger(javaClass)

    val batchSize = 1000
    var totalUpdated = 0L

    fun updatePositions() {
        log.info("m=updatePositions, step=init")
        val start = System.currentTimeMillis()

        repository.findAll()
                .buffer(batchSize)
                //.collectList()
                .flatMap { list ->
                    Flux.fromIterable(list).flatMap { custody -> calc(custody) }
                    Mono.just(list.size.toLong())
                }
                .doOnNext { batchSizeUpdated -> totalUpdated += batchSizeUpdated }
                .doOnComplete {
                    log.info("Processing time = ${System.currentTimeMillis() - start}, positions_updated = $totalUpdated")
                }
                .subscribe()

//        repository.findAll()
//                .buffer(batchSize)
//                .flatMap { custodies ->
//                    Flux.fromIterable(custodies)
//                        .flatMap { custody -> calc(custody) }
//                        .collectList()
//                        .map { it.size.toLong() }
//                }
//                .takeUntil { it == 0L }
//                .doOnNext { batchSizeUpdated -> totalUpdated += batchSizeUpdated }
//                .doOnComplete { log.info("Processing time = ${System.currentTimeMillis() - start}, positions_updated = $totalUpdated") }
//                .then(Mono.just(totalUpdated))
//                .subscribe()

    }

    private fun calc(custody: CustodyEntity): Mono<CustodyEntity> {
        // custody.value = custody.value.multiply(BigDecimal.valueOf(1.1))
        return Mono.just(custody)
    }

    fun getAll(): Flux<CustodyEntity> {
        return repository.findAll()
    }

    fun save(custodyEntity: CustodyEntity): Mono<CustodyEntity> {
        return repository.save(custodyEntity)
    }

    fun count(): Mono<Long> {
        return repository.count()
    }

    fun saveAll(list: List<CustodyEntity>): Mono<Int> {
        return repository.saveAll(list).collectList().flatMap {
            Mono.just(it.size)
        }
    }

}