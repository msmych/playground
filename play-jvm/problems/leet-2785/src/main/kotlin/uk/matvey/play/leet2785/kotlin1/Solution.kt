package uk.matvey.play.leet2785.kotlin1

import java.util.PriorityQueue

class Solution {
    fun sortVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val sortedVowels = PriorityQueue<Char>(naturalOrder())
        s.filter { it.lowercaseChar() in vowels }.forEach { sortedVowels.offer(it) }
        return s.map {
            if (it.lowercaseChar() in vowels) {
                sortedVowels.poll()
            } else {
                it
            }
        }.joinToString("") { it.toString() }
    }
}
