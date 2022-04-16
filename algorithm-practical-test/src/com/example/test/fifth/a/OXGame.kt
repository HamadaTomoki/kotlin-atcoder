package com.example.test.fifth.a

fun main() {
    val S = readLine()!!
    when{
        S.contains("ooo") -> println("o")
        S.contains("xxx") -> println("x")
        else -> println("draw")
    }
}
