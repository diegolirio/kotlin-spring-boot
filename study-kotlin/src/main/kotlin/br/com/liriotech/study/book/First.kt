package br.com.liriotech.study.book


fun main() {
    var ages = listOf(-18,-22,-23,-17,-27,-34, null)

    var old = ages.maxByOrNull { it?: 0 }
    println("Idade maior eh $old")
}

class First {

}
