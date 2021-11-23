package com.example.test.first.b

fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) { readLine()!!.toInt() }
    var previous = list[0]
    for (i in 1 until list.size) {
        val l = list[i]
        when {
            l == previous -> println("stay")
            l > previous -> println("up ${l - previous}")
            l < previous -> println("down ${previous - l}")
        }
        previous = l
    }
}
