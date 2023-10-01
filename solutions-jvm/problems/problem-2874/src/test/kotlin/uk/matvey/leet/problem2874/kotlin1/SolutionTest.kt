package uk.matvey.leet.problem2874.kotlin1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(12, 6, 1, 2, 7)

        val result = Solution().maximumTripletValue(nums)

        Assertions.assertThat(result).isEqualTo(77)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 10, 3, 4, 19)

        val result = Solution().maximumTripletValue(nums)

        Assertions.assertThat(result).isEqualTo(133)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 2, 3)

        val result = Solution().maximumTripletValue(nums)

        Assertions.assertThat(result).isEqualTo(0)
    }

    @Test
    fun case4() {
        val nums = intArrayOf(1000000, 1, 1000000)

        val result = Solution().maximumTripletValue(nums)

        Assertions.assertThat(result).isEqualTo(999999000000)
    }
}
