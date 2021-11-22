package com.example.test.first.a

fun main() {
    val s = readLine() ?: ""
    try {
        s.toInt()
    } catch (e: NumberFormatException) {
        return print("error")
    }
    if (s.length == 3) {
        return print("${s.toInt() * 2}")
    }
    print("error")
}
