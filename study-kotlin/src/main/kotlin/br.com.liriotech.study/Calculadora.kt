package br.com.liriotech.study

class Calculadora {
    fun execute(x: Int, y: Int, operador: String = "+"): Int {
        var result = 0
        when (operador) {
            "+" -> {
                result = x + y
            }
            "-" -> result = x - y
            "*" -> result = x * y
            "/" -> result = x / y
        }
        return result
    }

}

fun main() {
    val calc = Calculadora()
    val execute = calc.execute(10, 50)
    println(execute)

    println(calc.execute(5,9, "-"))
    println(calc.execute(5,9, "/"))
    println(calc.execute(5,9, "*"))
}