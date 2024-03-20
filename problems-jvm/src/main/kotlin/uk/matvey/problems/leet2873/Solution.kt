package uk.matvey.problems.leet2873

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun maximumTripletValue(nums: IntArray): Long {
        var max = 0L
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val triplet = (nums[i] - nums[j]).toLong() * nums[k]
                    if (triplet > max) {
                        max = triplet
                    }
                }
            }
        }
        return max
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(12, 6, 1, 2, 7)

        val result = Solution().maximumTripletValue(nums)

        assertThat(result).isEqualTo(77)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 10, 3, 4, 19)

        val result = Solution().maximumTripletValue(nums)

        assertThat(result).isEqualTo(133)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 2, 3)

        val result = Solution().maximumTripletValue(nums)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun case4() {
        val nums = intArrayOf(1000000, 1, 1000000)

        val result = Solution().maximumTripletValue(nums)

        assertThat(result).isEqualTo(999999000000)
    }
}
