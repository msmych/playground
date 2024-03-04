package uk.matvey.problems.leet0948

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val tokens = intArrayOf(100)

        val result = Solution().bagOfTokensScore(tokens, 50)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun case2() {
        val tokens = intArrayOf(200, 100)

        val result = Solution().bagOfTokensScore(tokens, 150)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case3() {
        val tokens = intArrayOf(100, 200, 300, 400)

        val result = Solution().bagOfTokensScore(tokens, 200)

        assertThat(result).isEqualTo(2)
    }
}
