package br.com.liriotech.study

import java.time.LocalDate
import java.time.LocalDateTime

class Class1 {
}

class Customer(val firstname: String, var lastname: String) {
    init {
        println("$firstname $lastname")
    }
}

class Product(val amount: Int, val price: Double) {

    //val priceTotal: Double = amount * price
    val priceTotal: Double get() = amount * price

//
//    init {
//        this.priceTotal = amount * price
//    }

    var name: String = ""
                set(value) {
                    field = value
                }

    val created: LocalDateTime
                get() {
                    return LocalDateTime.now();
                }



    fun total(): Double {
        return amount * price
    }

}

fun main() {
    val clazz = Class1()
    println(clazz)

    val customer = Customer("Diego", "Lirio")
    println(customer)
    println(customer.firstname)

    val p = Product(2, 5.99)
    println(p.total())
    println(p.priceTotal)

    println(p.created)
    p.name = "TV"
    println(p.name)

}