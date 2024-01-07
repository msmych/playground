package uk.matvey.play.leet0446.kotlin1

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