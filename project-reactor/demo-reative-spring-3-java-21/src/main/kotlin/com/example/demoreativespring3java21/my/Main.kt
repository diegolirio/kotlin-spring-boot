package com.example.demoreativespring3java21.my

class Main


fun main() {
    println("Goooooo!")

    val channel = YoutubeChannel()
    channel.addVideo("Trace")
    channel.addVideo("OT")
    channel.addVideo("Web")

    val userSubscriber = User("Diego")
    channel.subscribe(userSubscriber)

}