package uk.matvey.play.leet1335.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val jobDifficulty = intArrayOf(6, 5, 4, 3, 2, 1)

        val result = Solution().minDifficulty(jobDifficulty, 2)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case2() {
        val jobDifficulty = intArrayOf(9, 9, 9)

        val result = Solution().minDifficulty(jobDifficulty, 4)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun case3() {
        val jobDifficulty = intArrayOf(1, 1, 1)

        val result = Solution().minDifficulty(jobDifficulty, 3)

        assertThat(result).isEqualTo(3)
    }
}