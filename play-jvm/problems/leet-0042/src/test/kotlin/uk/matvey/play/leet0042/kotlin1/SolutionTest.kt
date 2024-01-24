package uk.matvey.play.leet0042.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)

        val result = Solution().trap(height)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun case2() {
        val height = intArrayOf(4, 2, 0, 3, 2, 5)

        val result = Solution().trap(height)

        assertThat(result).isEqualTo(9)
    }
}