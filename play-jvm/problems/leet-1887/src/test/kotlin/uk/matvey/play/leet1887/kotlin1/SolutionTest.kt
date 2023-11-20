package uk.matvey.play.leet1887.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
