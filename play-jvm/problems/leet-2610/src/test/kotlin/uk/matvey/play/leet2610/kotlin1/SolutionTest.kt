package uk.matvey.play.leet2610.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
