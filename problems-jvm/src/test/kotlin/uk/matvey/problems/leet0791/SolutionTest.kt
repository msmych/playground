package uk.matvey.problems.leet0791

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val result = Solution().customSortString("cba", "abcd")

        assertThat(result).contains("cba")
    }

    @Test
    fun case2() {
        val result = Solution().customSortString("bcafg", "abcd")

        assertThat(result).contains("bca")
    }
}
