package uk.matvey.problems.leet1743

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Solution {

    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val arr = IntArray(adjacentPairs.size + 1)
        val links = mutableMapOf<Int, MutableSet<Int>>()
        adjacentPairs.forEach {
            val a = it[0]
            val b = it[1]
            links.compute(a) {_, v -> ((v ?: setOf()) + b).toMutableSet() }
            links.compute(b) {_, v -> ((v ?: setOf()) + a).toMutableSet() }
        }
        var i = 0
        var n = links.filter { (_, v) -> v.size == 1 }.keys.first()
        while (i < arr.size) {
            arr[i] = n
            val next = links[n]?.singleOrNull()
            links.remove(n)
            next?.let {
                links.getValue(it).remove(n)
                n = it
            }
            i++
        }
        return arr
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val adjacentPairs = arrayOf(intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(3, 2))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(1, 2, 3, 4)
    }

    @Test
    fun case2() {
        val adjacentPairs = arrayOf(intArrayOf(4, -2), intArrayOf(1, 4), intArrayOf(-3, 1))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(-2, 4, 1, -3)
    }

    @Test
    fun case3() {
        val adjacentPairs = arrayOf(intArrayOf(100000,-100000))

        val result = Solution().restoreArray(adjacentPairs)

        assertThat(result).containsExactly(100000,-100000)
    }
}
