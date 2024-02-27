package uk.matvey.problems.leet2092

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val meetings = arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 3, 8), intArrayOf(1, 5, 10))

        val result = Solution().findAllPeople(6, meetings, 1)

        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 5)
    }

    @Test
    fun case2() {
        val meetings = arrayOf(intArrayOf(3, 1, 3), intArrayOf(1, 2, 2), intArrayOf(0, 3, 3))

        val result = Solution().findAllPeople(4, meetings, 3)

        assertThat(result).containsExactlyInAnyOrder(0, 1, 3)
    }

    @Test
    fun case3() {
        val meetings = arrayOf(intArrayOf(3, 4, 2), intArrayOf(1, 2, 1), intArrayOf(2, 3, 1))

        val result = Solution().findAllPeople(5, meetings, 1)

        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 4)
    }

    @Test
    fun case4() {
        val meetings = arrayOf(intArrayOf(0, 2, 1), intArrayOf(1, 3, 1), intArrayOf(4, 5, 1))

        val result = Solution().findAllPeople(6, meetings, 1)

        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3)
    }
}