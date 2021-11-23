package com.example.test.first.d


fun main() {
    val n = readLine()!!.toInt()
    val counts = MutableList(n + 1) { 0 }
    counts[0] = -1
    for (i in 1 until counts.size) {
        counts[readLine()!!.toInt()] += 1
    }
    if(counts.indexOf(2) == -1) return println("Correct")
    print("${counts.indexOf(2)} ${counts.indexOf(0)}")
}

val br = System.`in`.bufferedReader()
fun readLine() = br.readLine()!!
fun readInt() = readLine().toInt()
fun readInts() = readLine().split(" ").map(String::toInt)
fun readLong() = readLine().toLong()
fun readLongs() = readLine().split(" ").map(String::toLong)
fun <T> printAll(a: Iterable<T>) = println(a.joinToString("\n"))

