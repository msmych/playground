package uk.matvey.problems.leet2370

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.max

class Solution {

    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(26)
        var len = 0
        for (c in s) {
            val d = c - 'a'
            var next = 0
            for (last in 0..<26) {
                if (abs(last - d) <= k) {
                    next = max(next, dp[last])
                }
            }
            dp[d] = max(dp[d], next + 1)
            len = max(len, dp[d])
        }
        return len
    }
}

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().longestIdealString("acfgbd", 2)).isEqualTo(4)
    }

    @Test
    fun case2() {
        assertThat(Solution().longestIdealString("abcd", 3)).isEqualTo(4)
    }
}
