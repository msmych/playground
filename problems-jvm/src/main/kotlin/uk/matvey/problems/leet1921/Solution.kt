package uk.matvey.problems.leet1921

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val mins = dist.mapIndexed { i, d -> d / speed[i] + if (d % speed[i] > 0) 1 else 0 }.sorted()
        var count = 0
        var i = 0
        while (i < mins.size && count < mins[i]) {
            count++
            i++
        }
        return count
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val dist = intArrayOf(1, 3, 4)
        val speed = intArrayOf(1, 1, 1)

        val result = Solution().eliminateMaximum(dist, speed)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case2() {
        val dist = intArrayOf(1, 1, 2, 3)
        val speed = intArrayOf(1, 1, 1, 1)

        val result = Solution().eliminateMaximum(dist, speed)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case3() {
        val dist = intArrayOf(3, 2, 4)
        val speed = intArrayOf(5, 3, 2)

        val result = Solution().eliminateMaximum(dist, speed)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case4() {
        val dist = intArrayOf(3, 5, 7, 4, 5)
        val speed = intArrayOf(2, 3, 6, 3, 2)

        val result = Solution().eliminateMaximum(dist, speed)

        assertThat(result).isEqualTo(2)
    }
}
