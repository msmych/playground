package uk.matvey.play.leet1743.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val adjacentPairs = arrayOf(intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(3, 2))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(1, 2, 3, 4)
    }

    @Test
    fun case2() {
        val adjacentPairs = arrayOf(intArrayOf(4, -2), intArrayOf(1, 4), intArrayOf(-3, 1))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(-2, 4, 1, -3)
    }

    @Test
    fun case3() {
        val adjacentPairs = arrayOf(intArrayOf(100000,-100000))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(100000,-100000)
    }
}
