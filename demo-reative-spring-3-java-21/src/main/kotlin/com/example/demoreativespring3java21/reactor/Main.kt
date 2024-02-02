package com.example.demoreativespring3java21.reactor

import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime

class Main

fun main() {
    val publisher = YoutubeChannel()
    publisher.addVideo(Video(name="Curso de Kotlin", description = "leia mais", likes = 4, views = 10))
    publisher.addVideo(Video(name="Curso de Kotlin pt.2", description = "leia mais...", likes = 2, views = 5))
    publisher.addVideo(Video(name="Curso de Kotlin pt.3", description = "leia mais...", likes = 1, views = 2))

    //val subscriber = User("Diego")
    //publisher.allVideos().subscribeWith(subscriber)

    //publisher.allVideos().log().subscribe()
    //publisher.allVideos().log().subscribe(System.out::println)
//    publisher.allVideos().log().subscribe(
//        { it -> println(it) },
//        { throwable -> println(throwable) },
//        { println("Finished") }
//    )

    val flux = Flux.just(1,2,3,4).log().delayElements(Duration.ofSeconds(1))
    flux.subscribe {
        println(LocalDateTime.now())
        println(it)
    }



}