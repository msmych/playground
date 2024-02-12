package uk.matvey.play.leet0169.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(3, 2, 3)

        val result = Solution().majorityElement(nums)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)

        val result = Solution().majorityElement(nums)

        assertThat(result).isEqualTo(2)
    }
}
