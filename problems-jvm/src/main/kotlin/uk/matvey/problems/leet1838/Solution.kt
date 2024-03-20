package uk.matvey.problems.leet1838

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TestCaseReader

class Solution {

    fun maxFrequency(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        var max = 0
        var left = 0
        var right = 0
        var sum = 0
        while (right < nums.size) {
            var square = (right - left + 1) * sorted[right]
            sum += sorted[right]
            while (k < square - sum) {
                square -= sorted[right]
                sum -= sorted[left]
                left++
            }
            if (right - left + 1 > max) {
                max = right - left + 1
            }
            right++
        }
        return max
    }
}

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
        val nums = TestCaseReader("leet1838/case4").parseIntArr("nums.txt")

        val result = Solution().maxFrequency(nums, 10000)

        assertThat(result).isEqualTo(141)
    }
}
