package com.example.test.fifth.b

fun main() {
    val N = readLine()!!
    val S = readLine()!!
    var T = ""
    for (i in 0 until N.toInt()) {
        val prefix = S.substring(i, i + 1)
        T = T.replace(prefix, "").plus(prefix)
    }
    print(T)
}
