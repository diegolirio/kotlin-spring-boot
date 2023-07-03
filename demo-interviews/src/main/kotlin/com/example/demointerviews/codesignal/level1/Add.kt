package com.example.demointerviews.codesignal.level1

import java.math.BigDecimal

class SumOf2Numbers {
    fun solution(param1: Int, param2: Int): Int {
        //return param1 + param2
        return BigDecimal(param1).plus(BigDecimal(param2)).intValueExact()
    }
}

fun main() {
    println(SumOf2Numbers().solution(1, 3))
}