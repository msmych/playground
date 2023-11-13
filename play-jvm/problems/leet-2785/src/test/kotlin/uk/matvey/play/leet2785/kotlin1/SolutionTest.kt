package uk.matvey.play.leet2785.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val result = Solution().sortVowels("lEetcOde")

        assertThat(result).isEqualTo("lEOtcede")
    }

    @Test
    fun case2() {
        val result = Solution().sortVowels("lYmpH")

        assertThat(result).isEqualTo("lYmpH")
    }
}
