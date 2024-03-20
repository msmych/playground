package uk.matvey.problems.leet2958

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val freq = mutableMapOf<Int, Int>()
        val problematic = mutableSetOf<Int>()
        var left = 0
        var right = 0
        var maxLen = 0
        while (right < nums.size) {
            val rightNum = nums[right]
            freq.merge(rightNum, 1, Integer::sum)
            if (freq.getValue(rightNum) > k) {
                problematic += rightNum
            }
            if (problematic.isEmpty()) {
                maxLen = maxOf(maxLen, right - left + 1)
            } else {
                val leftNum = nums[left]
                freq.merge(leftNum, -1, Integer::sum)
                if (freq.getValue(leftNum) <= k) {
                    problematic -= leftNum
                }
                left++
            }
            right++
        }
        return maxLen
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 2, 3, 1, 2, 3, 1, 2)

        val result = Solution().maxSubarrayLength(nums, 2)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 2, 1, 2, 1, 2, 1, 2)

        val result = Solution().maxSubarrayLength(nums, 1)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(5, 5, 5, 5, 5, 5, 5)

        val result = Solution().maxSubarrayLength(nums, 4)

        assertThat(result).isEqualTo(4)
    }
}
