package com.example.demooperators.operators

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration

class RangeOperatorTests {

    @Test
    fun fluxRange() {
        val flux = Flux.range(1,4).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }

}