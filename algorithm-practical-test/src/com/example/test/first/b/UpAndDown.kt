package com.example.test.first.b

fun main() {
    val n = readLine()!!.toInt()
    var buffer = 0
    var i = 0
    List(n) { readLine()!!.toInt() }.forEach {
        if (i != 0) {
            when {
                it == buffer -> println("stay")
                it > buffer -> println("up ${it - buffer}")
                it < buffer -> println("down ${buffer - it}")
            }
        }
        buffer = it
        i++
    }
}
