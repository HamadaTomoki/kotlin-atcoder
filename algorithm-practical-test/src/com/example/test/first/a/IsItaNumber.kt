package com.example.test.first.a

fun main() {
    val s = readLine()!!
    run {
        try {
            if (s.length == 3) return@run print("${s.toInt() * 2}")
        } catch (e: NumberFormatException) {
            return print("error")
        }
        print("error")
    }
}
