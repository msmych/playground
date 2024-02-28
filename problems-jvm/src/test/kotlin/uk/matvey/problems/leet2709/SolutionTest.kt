package uk.matvey.problems.leet2709

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 3, 6)

        val result = Solution().canTraverseAllPairs(nums)

        assertThat(result).isTrue()
    }

    @Test
    fun case2() {
        val nums = intArrayOf(3, 9, 5)

        val result = Solution().canTraverseAllPairs(nums)

        assertThat(result).isFalse()
    }

    @Test
    fun case3() {
        val nums = intArrayOf(4, 3, 12, 8)

        val result = Solution().canTraverseAllPairs(nums)

        assertThat(result).isTrue()
    }
}