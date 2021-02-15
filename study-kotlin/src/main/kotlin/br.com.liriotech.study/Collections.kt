package br.com.liriotech.study

class Collections {



}

fun main () {
    val idades = intArrayOf(10,12,17, 18, 19, 22, 26, 29, 34)

    println(idades.contentToString())

//    for(it in idades) {
//        if(it > 25) {
//            println(it)
//        }
//    }

    idades.filter { it >= 18 }.forEach(::println)

    idades.filter { it >= 18 }.forEach {
        println("Idade $it, voce esta autorizado")
    }

    val salarios = doubleArrayOf(1000.0, 1520.99)
    salarios.forEachIndexed { index, salario ->
        if(salario < 1500) {
            salarios[index] += 300.00
        }
        println(salarios[index])
    }

//    salarios.map {
//        var salario = it
//        if(salario < 1500) {
//            salario += 100.00
//        }
//        salario
//    }.forEach(::println)
//
    salarios.map {
        if(it < 1500.0) it + 50.0 else it
    }.forEach(::println)

    val lista = mutableListOf("Diego", "Lirio", "Damacena")

    lista.forEach{ item -> println(item)}

    lista.get(1).also(::println)
    lista.indexOf("Lirio").also(::println)

    lista.add("Pereira")

    lista.sorted().forEach(::println)

    val alunos = listOf(Aluno("Diego", 34), Aluno("Tati", 35))

    alunos.sortedBy { it.age }.forEach(::println)
    alunos.reversed().forEach(::println)

}

data class Aluno(val name: String, val age: Int)