package com.example.test.first.c

fun main() {
    print(readLine()!!.split(" ").map { it.toInt() }.sorted().reversed()[2])
}
