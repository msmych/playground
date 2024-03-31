package uk.matvey.problems.leet2444

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.min

class Solution {

    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var count = 0L
        var left = -1
        var right = -1
        var br = -1
        nums.forEachIndexed { i, num ->
            if (num < minK || num > maxK) {
                br = i
            }
            if (num == minK) {
                left = i
            }
            if (num == maxK) {
                right = i
            }
            count += (min(left, right) - br).coerceAtLeast(0)
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 3, 5, 2, 7, 5)

        val result = Solution().countSubarrays(nums, 1, 5)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 1, 1, 1)

        val result = Solution().countSubarrays(nums, 1, 1)

        assertThat(result).isEqualTo(10)
    }
}