package com.example.test.first.f


fun main() {
    val s = readLine()!!
    val wordList = mutableListOf<String>()
    var start = 0
    while (start < s.length) {
        var end = start + 1
        while (s[end].isLowerCase()) ++end
        wordList.add(s.substring(start..end))
        start = end + 1
    }
    print(wordList.sortedBy { it.toLowerCase() }.joinToString(""))
}
