package uk.matvey.play.leet0632.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = listOf(
            listOf(4, 10, 15, 24, 26),
            listOf(0, 9, 12, 20),
            listOf(5, 18, 22, 30),
        )

        val result = Solution().smallestRange(nums)

        assertThat(result).containsExactly(20, 24)
    }

    @Test
    fun case2() {
        val nums = listOf(
            listOf(1, 2, 3),
            listOf(1, 2, 3),
            listOf(1, 2, 3),
        )

        val result = Solution().smallestRange(nums)

        assertThat(result).containsExactly(1, 1)
    }
}
