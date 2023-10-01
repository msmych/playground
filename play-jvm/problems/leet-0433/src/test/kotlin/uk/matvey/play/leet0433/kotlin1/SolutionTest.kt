package uk.matvey.play.leet0433.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun case1() {
        val startGene = "AACCGGTT"
        val endGene = "AACCGGTA"
        val bank = arrayOf("AACCGGTA")

        val result = Solution().minMutation(startGene, endGene, bank)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case2() {
        val startGene = "AACCGGTT"
        val endGene = "AAACGGTA"
        val bank = arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA")

        val result = Solution().minMutation(startGene, endGene, bank)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun case3() {
        val startGene = "AACCGGTT"
        val endGene = "AACCGGTA"
        val bank = arrayOf<String>()

        val result = Solution().minMutation(startGene, endGene, bank)

        assertThat(result).isEqualTo(-1)
    }
}
