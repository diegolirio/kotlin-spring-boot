package com.example.demoreativespring3java21

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.test.StepVerifier
import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.CompletableFuture

class FluxGenerateTest {

    @Test
    fun generate() {
        val fileAbsolutePath = "/Users/ddamacena/Documents/Lirio-Tech/kotlin-spring-boot/demo-reative-spring-3-java-21/src/test/resources/reator.txt"

        val flux = Flux.generate(
            {
                BufferedReader(FileReader(fileAbsolutePath))
            },
            {
                reader, sink ->
                val line = reader.readLine()
                if (line != null) {
                    sink.next(reader)
                } else {
                    try {
                        val line = reader.readLine()
                        if(line != null) {
                            sink.next(line)
                        } else {
                            sink.complete()
                        }
                    } catch (e: Exception) {
                        sink.error(e)
                    }
                    sink.complete()
                }
                reader
            },
            { reader ->
                println("File finished!!!")
                reader.close()
            }
        ).log()

        StepVerifier.create(flux)
            .expectNext("Line one",
                    "Line two",
                    "Line 3",
                    "Line Four",
                    "Line 5",
                    "Line 6")
            .verifyComplete()
    }

}