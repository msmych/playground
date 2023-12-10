package uk.matvey.play.leet2958.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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