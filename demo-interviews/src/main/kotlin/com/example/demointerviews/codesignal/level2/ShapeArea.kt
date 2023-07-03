package com.example.demointerviews.codesignal.level2

import kotlin.math.pow

class ShapeArea {

    fun solution(n: Int): Int {
        if(n < 1 && n >= 10.0.pow(4.0)) { // 1 ≤ n < 10^4
            throw RuntimeException("n should be between 1 and 10^4")
        }

        // n=3
        // (3 * 3) + ((3 - 1) * (3 - 1))
        // 9 + (2 * 2)
        // 9 + 4
        // 13

        // return 1 + 2 * n * (n-1);
        // return (n * n) + ((n - 1) * (n -1))
        return (n.toDouble().pow(2.0) + (n-1).toDouble().pow(2.0)).toInt()
    }
}

fun main() {
    println(ShapeArea().solution(3))
}

