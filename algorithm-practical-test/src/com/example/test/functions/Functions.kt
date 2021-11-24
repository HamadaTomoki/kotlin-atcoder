package com.example.test.functions

val br = System.`in`.bufferedReader()
fun readLine() = br.readLine()!!
fun readInt() = readLine().toInt()
fun readInts() = readLine().split(" ").map(String::toInt)
fun readLong() = readLine().toLong()
fun readLongs() = readLine().split(" ").map(String::toLong)
fun <T> printAll(a: Iterable<T>) = println(a.joinToString("\n"))
