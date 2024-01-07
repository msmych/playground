package uk.matvey.play.leet0446.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(2, 4, 6, 8, 10)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(7, 7, 7, 7, 7)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(16)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(0, 2000000000, -294967296)

        val result = Solution().numberOfArithmeticSlices(nums)

        assertThat(result).isEqualTo(0)
    }
}