package uk.matvey.problems.leet0446

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val n = nums.size
        val grouped = (0 until n).groupBy { nums[it].toLong() }
        val dp = MutableList(n) { MutableList(n) { 0 } }
        var count = 0
        (1 until n).forEach { i ->
            (i + 1 until n).forEach { j ->
                val a = 2L * nums[i] - nums[j]
                if (grouped.containsKey(a)) {
                    for (k in grouped.getValue(a)) {
                        if (k < i) {
                            dp[i][j] += dp[k][i] + 1
                        } else {
                            break
                        }
                    }
                }
                count += dp[i][j]
            }
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 4, 6, 8, 10)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(7, 7, 7, 7, 7)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(16)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(0, 2000000000, -294967296)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(0)
    }
}
