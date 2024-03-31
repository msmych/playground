package uk.matvey.problems.leet0992

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TestCaseReader

class Solution {

    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        val freq = MutableList(nums.size + 1) { 0 }
        var count = 0
        var left = 0
        var right = 0
        var subs = 0
        var n = k
        while (right < nums.size) {
            if (freq[nums[right++]]++ == 0) {
                n--
            }
            if (n < 0) {
                freq[nums[left++]]--
                n++
                subs = 0
            }
            if (n == 0) {
                while (freq[nums[left]] > 1) {
                    freq[nums[left++]]--
                    subs++
                }
                count += subs + 1
            }
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 2, 1, 2, 3)

        val result = Solution().subarraysWithKDistinct(nums, 2)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 2, 1, 3, 4)

        val result = Solution().subarraysWithKDistinct(nums, 3)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(2, 1, 2, 1, 2)

        val result = Solution().subarraysWithKDistinct(nums, 2)

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun case4() {
        val nums = TestCaseReader("leet0992/case4").parseIntArr("nums.txt")

        val result = Solution().subarraysWithKDistinct(nums, 360)

        assertThat(result).isEqualTo(10013)
    }
}