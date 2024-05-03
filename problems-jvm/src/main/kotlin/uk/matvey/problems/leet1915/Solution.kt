package uk.matvey.problems.leet1915

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun wonderfulSubstrings(word: String): Long {
        val n = word.length
        val freq = HashMap<Int, Int>()
        freq[0] = 1
        var mask = 0
        var count = 0L
        for (i in 0..<n) {
            val c = word[i]
            val bit = c - 'a'
            mask = mask xor (1 shl bit)
            val next = freq.getOrDefault(mask, 0)
            count += next
            freq[mask] = next + 1
            for (j in 0..<10) {
                count += freq.getOrDefault(mask xor (1 shl j), 0)
            }
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().wonderfulSubstrings("aba")).isEqualTo(4)
    }

    @Test
    fun case2() {
        assertThat(Solution().wonderfulSubstrings("aabb")).isEqualTo(9)
    }

    @Test
    fun case3() {
        assertThat(Solution().wonderfulSubstrings("he")).isEqualTo(2)
    }
}