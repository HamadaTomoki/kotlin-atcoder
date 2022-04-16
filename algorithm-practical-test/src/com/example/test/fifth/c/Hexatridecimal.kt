package com.example.test.fifth.c

fun main() {
    var N = readLine()!!.toInt()
    val S = 36
    val alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val list = mutableListOf<String>()
    while (N / S != 0) {
        list.add(alphabet[N % S].toString())
        N /= S
    }
    list.add(alphabet[N % S].toString())
    print(list.reversed().joinToString(""))
}
