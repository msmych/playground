package uk.matvey.problems.leet1531

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val n = s.length
        val dp = MutableList(n + 1) { MutableList(k + 1) { 1_000_000 } }
        dp[0][0] = 0
        (1..n).forEach { i ->
            (0..k).forEach { j ->
                var count = 0
                var d = 0
                (1..i).reversed().forEach { r ->
                    if (s[r - 1] == s[i - 1]) {
                        count++
                    } else {
                        d++
                    }
                    if (j - d >= 0) {
                        val a = when {
                            count >= 100 -> 3
                            count >= 10 -> 2
                            count >= 2 -> 1
                            else -> 0
                        }
                        val v = dp[r - 1][j - d] + 1 + a
                        if (v < dp[i][j]) {
                            dp[i][j] = v
                        }
                    }
                }
                if (j > 0 && dp[i - 1][j - 1] < dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - 1]
                }
            }
        }
        return dp[n][k]
    }
}

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().getLengthOfOptimalCompression("aaabcccd", 2)).isEqualTo(4)
    }

    @Test
    fun case2() {
        assertThat(Solution().getLengthOfOptimalCompression("aabbaa", 2)).isEqualTo(2)
    }

    @Test
    fun case3() {
        assertThat(Solution().getLengthOfOptimalCompression("aaaaaaaaaaa", 0)).isEqualTo(3)
    }
}
