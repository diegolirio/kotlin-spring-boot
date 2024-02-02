package com.example.demoreativespring3java21

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.time.Duration
import java.util.stream.Stream

class ReactorOperatorTests {

    @Test
    fun fluxJust() {
        val flux = Flux.just(1,2,3,4).log().delayElements(Duration.ofSeconds(1))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()

    }

    @Test
    fun fluxFromIterable() {
        val flux = Flux.fromIterable(listOf(1,2,3,4)).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }

    @Test
    fun fluxFromArray() {
        val flux = Flux.fromArray(listOf(1,2,3,4).toTypedArray()).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }

    @Test
    fun fluxFromStream() {
        val flux = Flux.fromStream(Stream.of(1,2,3,4)).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }

    @Test
    fun fluxRange() {
        val flux = Flux.range(1,4).log().delayElements(Duration.ofMillis(10))
        StepVerifier.create(flux).expectNext(1,2,3,4).verifyComplete()
    }


}