package uk.matvey.problems.leet2785

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

class SolutionTest {

    @Test
    fun case1() {
        val result = Solution().sortVowels("lEetcOde")

        assertThat(result).isEqualTo("lEOtcede")
    }

    @Test
    fun case2() {
        val result = Solution().sortVowels("lYmpH")

        assertThat(result).isEqualTo("lYmpH")
    }
}
