package uk.matvey.problems.leet0514

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.abs

class Solution {

    fun findRotateSteps(ring: String, key: String): Int {
        val rl = ring.length
        val kl = key.length
        val dp = Array(rl) { IntArray(kl + 1) { Int.MAX_VALUE } }
        for (i in 0..<rl) {
            dp[i][kl] = 0
        }
        for (ki in (0..<kl).reversed()) {
            for (ri in 0..<rl) {
                for (rj in 0..<rl) {
                    if (ring[rj] == key[ki]) {
                        dp[ri][ki] = minOf(dp[ri][ki], 1 + steps(ri, rj, rl) + dp[rj][ki + 1])
                    }
                }
            }
        }
        return dp[0][0]
    }

    private fun steps(i: Int, next: Int, len: Int): Int {
        val d = abs(i - next)
        return minOf(d, len - d)
    }
}

class SolutionTest {

    @Test
    fun case1() {
        assertThat(Solution().findRotateSteps("godding", "gd")).isEqualTo(4)
    }

    @Test
    fun case2() {
        assertThat(Solution().findRotateSteps("godding", "godding")).isEqualTo(13)
    }
}
