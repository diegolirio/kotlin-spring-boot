package com.example.demofile

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.apache.commons.io.IOUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.util.*
import kotlin.streams.toList

@RestController
@RequestMapping("/file")
class CustomerController {

    @PostMapping("/wallets")
    fun fileUpload(@RequestParam("file") file: MultipartFile): String? {
        println(file.originalFilename)
        val stream = ByteArrayInputStream(file.bytes)
        return IOUtils.toString(stream, "UTF-8")
    }

    @GetMapping
    fun getList(): List<String> {
        val i = System.currentTimeMillis()
        try {
            val listOf = getList(100)
            return listOf.parallelStream().map {
                Thread.sleep(2000)
                "$it=${UUID.randomUUID().toString()}.txt"
            }.toList()
        } finally {
            println(System.currentTimeMillis() - i)
        }
    }


}

fun getList(amount: Int): MutableList<String> {
    val list = mutableListOf<String>()
    for(i in 0..amount) {
        list.add("file$i")
    }
    return list
}

fun main() {
    runCoroutines()
    //parallelStream() // 15s
}

fun runCoroutines() { // this: CoroutineScope
    val i = System.currentTimeMillis()
    var listOf = getList(100)
    runBlocking {
        val toList = listOf.map {
            launch {
                delay(1000)
                listOf.add("$it=${UUID.randomUUID().toString()}.txt")
            }
        }.toList()
        println(toList)
    }

    println(System.currentTimeMillis() - i)
}

fun parallelStream() {
    val i = System.currentTimeMillis()
    try {
        val listOf = getList(100)
        val toList = listOf.parallelStream().map {
            Thread.sleep(1000)
            "$it=${UUID.randomUUID().toString()}.txt"
        }.toList()
        println(toList)
    } finally {
        println(System.currentTimeMillis() - i)
    }
}

//fun main() = runBlocking {
//    val i = System.currentTimeMillis()
//    try {
//        val listOf = getList(100)
//        listOf.map {
//            launch {
//                delay(2000)
//                "$it=${UUID.randomUUID().toString()}.txt"
//            }
//        }.toList()
//    } finally {
//        println(System.currentTimeMillis() - i)
//    }
//}