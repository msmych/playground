package uk.matvey.problems.leet2865

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        return maxHeights.mapIndexed { tipIndex, tipHeight ->
            var ceiling = tipHeight
            var sum = 0L
            (0 until tipIndex).reversed().forEach { i ->
                val height = maxHeights[i]
                if (height < ceiling) {
                    ceiling = height
                }
                sum += ceiling
            }
            ceiling = tipHeight
            (tipIndex + 1 until maxHeights.size).forEach { i ->
                val height = maxHeights[i]
                if (height < ceiling) {
                    ceiling = height
                }
                sum += ceiling
            }
            sum + tipHeight
        }.max()
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val maxHeights = listOf(5, 3, 4, 1, 1)

        val result = Solution().maximumSumOfHeights(maxHeights)

        assertThat(result).isEqualTo(13)
    }

    @Test
    fun case2() {
        val maxHeights = listOf(6, 5, 3, 9, 2, 7)

        val result = Solution().maximumSumOfHeights(maxHeights)

        assertThat(result).isEqualTo(22)
    }

    @Test
    fun case3() {
        val maxHeights = listOf(3, 2, 5, 5, 2, 3)

        val result = Solution().maximumSumOfHeights(maxHeights)

        assertThat(result).isEqualTo(18)
    }

    @Test
    fun case4() {
        val maxHeights = listOf(3, 6, 3, 5, 5, 1, 2, 5, 5, 5)

        val result = Solution().maximumSumOfHeights(maxHeights)

        assertThat(result).isEqualTo(24)
    }
}
