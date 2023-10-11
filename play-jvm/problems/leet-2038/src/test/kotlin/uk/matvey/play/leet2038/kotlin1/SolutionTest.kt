package uk.matvey.play.leet2038.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.play.utils.CaseParamsReader
import uk.matvey.play.utils.CaseParamsReader.CASE_PARAMS_READER

class SolutionTest {

    @Test
    fun case1() {
        val colors = "AAABABB"

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isTrue()
    }

    @Test
    fun case2() {
        val colors = "AA"

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isFalse()
    }

    @Test
    fun case3() {
        val colors = "ABBBBBBBAAA"

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isFalse()
    }

    @Test
    fun case4() {
        val colors = "AAAAABBB"

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isTrue()
    }

    @Test
    fun case5() {
        val colors = CASE_PARAMS_READER.readString("case5/colors.txt")

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isTrue()
    }
}
