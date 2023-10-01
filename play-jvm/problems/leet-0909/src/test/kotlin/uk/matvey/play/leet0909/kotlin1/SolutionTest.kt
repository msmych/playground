package uk.matvey.play.leet0909.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 35, -1, -1, 13, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 15, -1, -1, -1, -1),
        )

        val result = Solution().snakesAndLadders(board)

        assertThat(result).isEqualTo(4)
    }
}
