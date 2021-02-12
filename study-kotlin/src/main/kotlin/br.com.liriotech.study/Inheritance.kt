package br.com.liriotech.study

// open class Person(val name: String)

open class Person() {
    var name: String = "Fulano"
    constructor(name: String): this() {
        this.name = name
    }

    open fun toStr(): String {
        return "name=$name"
    }
}

class Employee(name: String, val cpf: String): Person(name) {
    override fun toStr(): String {
        return "name=$name, cpf=$cpf"
    }
}

fun main() {
    val p = Employee("Diego", "6532121")
    println(p.toStr())
}