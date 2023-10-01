package uk.matvey.play.leet0433.kotlin1

import java.util.LinkedList

class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (startGene == endGene) {
            return 0
        }
        val seen = HashSet<String>()
        val mutations = LinkedList<String>()
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
