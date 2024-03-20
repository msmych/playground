package uk.matvey.problems.leet1887

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun reductionOperations(nums: IntArray): Int {
        val sorted = nums.sorted()
        var count = 0
        var max = sorted.last()
        (0 until sorted.size - 1).reversed().forEach { i ->
            val num = sorted[i]
            if (num != max) {
                count += sorted.size - i - 1
                max = num
            }
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(5, 1, 3)

        val result = Solution().reductionOperations(nums)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 1, 1)

        val result = Solution().reductionOperations(nums)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 1, 2, 2, 3)

        val result = Solution().reductionOperations(nums)

        assertThat(result).isEqualTo(4)
    }
}
