package com.example.demointerviews.codesignal.level2

class ArrayIntegerLargestProduct {

    fun solution(inputArray: MutableList<Int>): Int {
        //mutableListOf(3, 6, -2, -5, 7, 3) // -> 21
        var largest = Int.MIN_VALUE
        for (i in 0 until inputArray.size) {
            println("i = $i")
            val product = inputArray[i] * inputArray[i + 1]
            println("product = $product")
            if (product > largest) largest = product
        }
        return largest
    }

}

fun main() {
    mutableListOf(3, 6, -2, -5, 7, 3) // -> 21
        // mutableListOf(-1, -2) -> 2
        .let { ints ->
            ArrayIntegerLargestProduct()
                .solution(ints)
                .also { println(it) }
        }


}
