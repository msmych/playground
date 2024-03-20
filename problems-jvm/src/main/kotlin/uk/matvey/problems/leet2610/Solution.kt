package uk.matvey.problems.leet2610

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun findMatrix(nums: IntArray): List<List<Int>> {
        val groups = nums.groupBy { it }.values.sortedBy { -it.size }
        return (0 until groups[0].size).map { i -> groups.filter { i < it.size }.map { it[i] } }
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 3, 4, 1, 2, 3, 1)

        val result = Solution().findMatrix(nums)

        assertThat(result).containsExactlyInAnyOrder(listOf(1, 3, 4, 2), listOf(1, 3), listOf(1))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 2, 3, 4)

        val result = Solution().findMatrix(nums)

        assertThat(result).containsExactlyInAnyOrder(listOf(1, 2, 3, 4))
    }
}
