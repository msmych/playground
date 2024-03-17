package uk.matvey.problems.leet0424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun characterReplacement(s: String, k: Int): Int {
        var maxLen = 0
        s.toSet().forEach { c ->
            var countOther = 0
            var left = 0
            var right = 0
            while (right < s.length) {
                if (countOther <= k) {
                    if (s[right] != c) {
                        countOther++
                    }
                    right++
                } else {
                    if (s[left] != c) {
                        countOther--
                    }
                    left++
                }
                if (countOther <= k && right - left > maxLen) {
                    maxLen = right - left
                }
            }
        }
        return maxLen
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val result = Solution().characterReplacement("ABAB", 2)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun case2() {
        val result = Solution().characterReplacement("AABABBA", 1)

        assertThat(result).isEqualTo(4)
    }
}
