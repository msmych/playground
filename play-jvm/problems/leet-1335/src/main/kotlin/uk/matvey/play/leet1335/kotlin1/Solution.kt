package uk.matvey.play.leet1335.kotlin1

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
                (i - 1..< j).reversed().forEach { k ->
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