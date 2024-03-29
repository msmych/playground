package uk.matvey.problems.leet2962

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TestCaseReader

class Solution {

    fun countSubarrays(nums: IntArray, k: Int): Long {
        val max = nums.max()
        val maxIndexes = mutableListOf<Int>()
        var count = 0L
        nums.forEachIndexed { index, i ->
            if (i == max) {
                maxIndexes += index
            }
            val maxCount = maxIndexes.size
            if (maxCount >= k) {
                count += maxIndexes[maxCount - k] + 1
            }
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 3, 2, 3, 3)

        val result = Solution().countSubarrays(nums, 2)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 4, 2, 1)

        val result = Solution().countSubarrays(nums, 3)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(
            61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82
        )

        val result = Solution().countSubarrays(nums, 2)

        assertThat(result).isEqualTo(224)
    }

    @Test
    fun case4() {
        val nums = TestCaseReader("leet2962/case4").parseIntArr("nums.txt")

        val result = Solution().countSubarrays(nums, 2988)

        assertThat(result).isEqualTo(1203812585)
    }

    @Test
    fun case5() {
        val nums = TestCaseReader("leet2962/case5").parseIntArr("nums.txt")

        val result = Solution().countSubarrays(nums, 2)

        assertThat(result).isEqualTo(4999800002)
    }
}