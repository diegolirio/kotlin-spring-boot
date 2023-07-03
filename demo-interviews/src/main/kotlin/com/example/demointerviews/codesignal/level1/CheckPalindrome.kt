package com.example.demointerviews.codesignal.level1

class Palindrome {
    fun solution(inputString: String): Boolean {
        var reserveWord = ""
        for(char in inputString) {
            reserveWord = char + reserveWord
        }
        println("$reserveWord == $inputString")
        return reserveWord == inputString
    }
}

fun main() {
    println(Palindrome().solution("Mundo Invertido"))
}