package uk.matvey.play.leet0480.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)

        val result = Solution().medianSlidingWindow(nums, 3)

        assertThat(result).containsExactly(1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 2, 3, 4, 2, 3, 1, 4, 2)

        val result = Solution().medianSlidingWindow(nums, 3)

        assertThat(result).containsExactly(2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)

        val result = Solution().medianSlidingWindow(nums, 4)

        assertThat(result).containsExactly(0.0, 1.0, 1.0, 4.0, 5.5)
    }

    @Test
    fun case4() {
        val nums = intArrayOf(1)

        val result = Solution().medianSlidingWindow(nums, 1)

        assertThat(result).containsExactly(1.0)
    }

    @Test
    fun case5() {
        val nums = intArrayOf(2147483647, 2147483647)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(2147483647.0)
    }

    @Test
    fun case6() {
        val nums = intArrayOf(2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(1073741824.0, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1073741827.0)
    }

    @Test
    fun case7() {
        val nums = intArrayOf(9, 7, 0, 3, 9, 8, 6, 5, 7, 6)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(
            8.00000,
            3.50000,
            1.50000,
            6.00000,
            8.50000,
            7.00000,
            5.50000,
            6.00000,
            6.50000
        )
    }
}
