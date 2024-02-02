package com.example.demoreativespring3java21

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.test.StepVerifier
import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.CompletableFuture

class FluxCreateOneTest {

    @Test
    fun readFileTest() {
        val fileAbsolutePath = "/Users/ddamacena/Documents/Lirio-Tech/kotlin-spring-boot/demo-reative-spring-3-java-21/src/test/resources/reator.txt"
        val fileAbsolutePath2 = "/Users/ddamacena/Documents/Lirio-Tech/kotlin-spring-boot/demo-reative-spring-3-java-21/src/test/resources/reator2.txt"

        val flux = Flux.create<String> { sink ->
            val t1 = CompletableFuture.runAsync { readFileFluxSink(fileAbsolutePath, sink) }
            val t2 = CompletableFuture.runAsync { readFileFluxSink(fileAbsolutePath2, sink) }
            CompletableFuture.allOf(t1, t2).join()
            sink.complete()
        }.log()

        StepVerifier.create(flux)
            .expectNextCount(9)
            .verifyComplete()
    }

    private fun readFileFluxSink(fileAbsolutePath: String, sink: FluxSink<String>) {
        println("File => $fileAbsolutePath :: Thread => ${Thread.currentThread().name}")
//            val result = kotlin.runCatching {
//                BufferedReader(FileReader(fileAbsolutePath))
//            }
//            result.onSuccess { reader ->
//                reader.useLines { line ->
//                    line.forEach { sink.next() }
//                }
//
//            }.onFailure { e ->
//                // Handle the exception
//                sink.error(e)
//            }
//            sink.complete()

        try {
            val reader = BufferedReader(FileReader(fileAbsolutePath))
            var line: String? = reader.readLine()
            while (line != null) {
                sink.next(line)
                line = reader.readLine()
            }
            reader.close()
        } catch (e: Exception) {
            sink.error(e)
        }
    }
}