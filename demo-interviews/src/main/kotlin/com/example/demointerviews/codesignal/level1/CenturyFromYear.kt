package com.example.demointerviews.codesignal.level1

class GiveYearWhatCentury {

    fun solution(year: Int): Int {
        return if(year % 100 == 0) year / 100 else year / 100 + 1
    }

}

fun main() {
    println(GiveYearWhatCentury().solution(1700))
}