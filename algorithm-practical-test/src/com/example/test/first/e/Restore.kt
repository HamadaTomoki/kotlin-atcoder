package com.example.test.first.e

fun main() {
    // Variable declare
    val firstInput = readLine()!!.split(" ").map { it.toInt() }
    val N = firstInput[0] // N(SNS participant)
    val Q = firstInput[1] // Q(Number of log lines)
    val userMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    for (i in 1..Q) {
        val row = readLine()!!.split(" ").map { it.toInt() }
        val S = row[0]
        val from = row[1]
        val to = if (row.size == 3) {
            row[2]
        } else 0

        if (!userMap.containsKey(from)) userMap[from] = mutableListOf() // add user map
        val followList = userMap[from]!!
        when (S) {
            1 -> if (!followList.contains(to)) followList.add(to)
            2 -> {
                userMap.forEach { (k, v) ->
                    if (k != from) {
                        if (v.contains(from)) followList.add(k)
                    }
                }
            }
            3 -> {
                // ConcurrentModificationException does not occur by copying the list with toMutableList
                followList.toMutableList().forEach { x ->
                    userMap[x]?.forEach {
                        if(it != from) {
                            if(!followList.contains(it)) followList.add(it)
                        }
                    }
                }
            }
        }
    }
    for (n in 1..N) {
        for (i in 1..N) {
            when (i) {
                n -> print("N")
                else -> {
                    if (userMap[n]?.contains(i) == true) print("Y") else print("N")
                }
            }
        }
        println()
    }
    // println("-----------------------")
    // userMap.forEach { (k, v) ->
    //     print("$k: ")
    //     v.forEach {
    //         print("$it ")
    //     }
    //     println()
    // }
}


