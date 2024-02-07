package com.example.demooperators.operators

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration

class JustOperatorTest {

    /**
     * Params contains a varargs => just(T... data) of Any Type
     */
    @Test
    fun fluxJust() {
        val flux = Flux.just(1,2,3,4).log().delayElements(Duration.ofSeconds(1))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()

    }
}