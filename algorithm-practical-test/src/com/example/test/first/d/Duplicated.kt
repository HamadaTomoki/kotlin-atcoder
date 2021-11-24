package com.example.test.first.d


fun main() {
    val n = readLine()!!.toInt()
    val counts = MutableList(n + 1) { 0 }
    counts[0] = -1
    for (i in 1 until counts.size) {
        counts[readLine()!!.toInt()] += 1
    }
    if (counts.indexOf(2) == -1) return println("Correct")
    print("${counts.indexOf(2)} ${counts.indexOf(0)}")
}


