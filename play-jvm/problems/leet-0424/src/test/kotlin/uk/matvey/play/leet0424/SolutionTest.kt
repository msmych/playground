package uk.matvey.play.leet0424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.play.leet0424.kotlin1.Solution

class SolutionTest {

    @Test
    fun case1() {
        val result = Solution().characterReplacement("ABAB", 2)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun case2() {
        val result = Solution().characterReplacement("AABABBA", 1)

        assertThat(result).isEqualTo(4)
    }
}
