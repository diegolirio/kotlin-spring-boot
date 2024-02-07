package com.example.demooperators.operators

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration
import java.util.stream.Stream

class FromArrayOperatorTests {

    @Test
    fun fluxFromStream() {
        val flux = Flux.fromStream(Stream.of(1,2,3,4)).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }

}