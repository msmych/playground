package uk.matvey.problems.leet2038

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TestCaseReader

class Solution {

    fun winnerOfGame(colors: String): Boolean {
        var aCount = 0
        var bCount = 0
        var i = 0
        while (i < colors.length) {
            var count = 0
            val color = colors[i]
            while (i + count < colors.length && colors[i + count] == color) {
                count++
            }
            if (count >= 3) {
                if (color == 'A') {
                    aCount += count - 2
                } else {
                    bCount += count - 2
                }
            }
            i += count
        }
        return aCount > bCount
    }
}

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
        val testCaseReader = TestCaseReader("leet2038/case5");
        val colors = testCaseReader.readString("colors.txt")

        val result = Solution().winnerOfGame(colors)

        assertThat(result).isTrue()
    }
}
