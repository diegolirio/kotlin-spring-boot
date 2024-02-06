package com.example.reactorblockhound

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.blockhound.BlockHound

@SpringBootApplication
class ReactorBlockhoundApplication

fun main(args: Array<String>) {
    BlockHound.install()
    runApplication<ReactorBlockhoundApplication>(*args)
}


