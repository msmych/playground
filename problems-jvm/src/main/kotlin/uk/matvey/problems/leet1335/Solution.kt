package uk.matvey.problems.leet1335

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val n = jobDifficulty.size
        if (n < d) {
            return -1
        }
        val dp = MutableList(d + 1) { MutableList(n + 1) { Int.MAX_VALUE } }
        dp[0][0] = 0
        (1..d).forEach { i ->
            (1..n).forEach { j ->
                var max = 0
                (i - 1..<j).reversed().forEach { k ->
                    if (jobDifficulty[k] > max) {
                        max = jobDifficulty[k]
                    }
                    if (dp[i - 1][k] != Int.MAX_VALUE) {
                        val a = dp[i - 1][k] + max
                        if (a < dp[i][j]) {
                            dp[i][j] = a
                        }
                    }
                }
            }
        }
        return dp[d][n].takeUnless { it == Int.MIN_VALUE } ?: -1
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val jobDifficulty = intArrayOf(6, 5, 4, 3, 2, 1)

        val result = Solution().minDifficulty(jobDifficulty, 2)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case2() {
        val jobDifficulty = intArrayOf(9, 9, 9)

        val result = Solution().minDifficulty(jobDifficulty, 4)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun case3() {
        val jobDifficulty = intArrayOf(1, 1, 1)

        val result = Solution().minDifficulty(jobDifficulty, 3)

        assertThat(result).isEqualTo(3)
    }
}
