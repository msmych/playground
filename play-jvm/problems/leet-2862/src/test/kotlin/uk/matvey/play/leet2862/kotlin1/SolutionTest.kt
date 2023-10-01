package uk.matvey.play.leet2862.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun case1() {
        val nums = listOf(8, 7, 3, 5, 7, 2, 4, 9)

        val result = Solution().maximumSum(nums)

        assertThat(result).isEqualTo(16)
    }

    @Test
    fun case2() {
        val nums = listOf(5, 10, 3, 10, 1, 13, 7, 9, 4)

        val result = Solution().maximumSum(nums)

        assertThat(result).isEqualTo(19)
    }
}
