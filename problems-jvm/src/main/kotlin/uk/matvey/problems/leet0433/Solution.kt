package uk.matvey.problems.leet0433

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class Solution {

    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (startGene == endGene) {
            return 0
        }
        val seen = HashSet<String>()
        val mutations = ArrayDeque<String>()
        mutations.offer(startGene)
        var count = 1
        while (mutations.isNotEmpty()) {
            var steps = mutations.size
            while (steps > 0) {
                val gene = mutations.poll()
                val nextGenes = bank.filterNot { seen.contains(it) }
                    .filter { it.indices.count { i -> it[i] != gene[i] } == 1 }
                for (nextGene in nextGenes) {
                    if (nextGene == endGene) {
                        return count
                    }
                    seen += nextGene
                    mutations.offer(nextGene)
                }
                steps--
            }
            count++
        }
        return -1
    }
}

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
