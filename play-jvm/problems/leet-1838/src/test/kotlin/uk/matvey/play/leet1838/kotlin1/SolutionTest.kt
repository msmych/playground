package uk.matvey.play.leet1838.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import uk.matvey.play.utils.TestCaseReader

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 2, 4)

        val result = Solution().maxFrequency(nums, 5)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 4, 8, 13)

        val result = Solution().maxFrequency(nums, 5)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(3, 9, 6)

        val result = Solution().maxFrequency(nums, 2)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case4() {
        val nums = TestCaseReader("case4").parseIntArr("nums.txt")

        val result = Solution().maxFrequency(nums, 10000)

        assertThat(result).isEqualTo(141)
    }
}
