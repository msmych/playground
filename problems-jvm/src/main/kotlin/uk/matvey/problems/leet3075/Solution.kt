package uk.matvey.problems.leet3075

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sort()
        var sum = 0L
        var j = happiness.size - 1
        (0..<k).forEach { i ->
            sum += (happiness[j--] - i).coerceAtLeast(0)
        }
        return sum
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val happiness = intArrayOf(1, 2, 3)

        val result = Solution().maximumHappinessSum(happiness, 2)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun case2() {
        val happiness = intArrayOf(1, 1, 1, 1)

        val result = Solution().maximumHappinessSum(happiness, 2)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case3() {
        val happiness = intArrayOf(2, 3, 4, 5)

        val result = Solution().maximumHappinessSum(happiness, 1)

        assertThat(result).isEqualTo(5)
    }
}
