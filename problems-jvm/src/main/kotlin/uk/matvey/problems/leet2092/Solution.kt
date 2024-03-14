package uk.matvey.problems.leet2092

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.TreeMap

class Solution {

    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val schedule = TreeMap<Int, MutableSet<Pair<Int, Int>>>()
        meetings.forEach { m ->
            schedule.putIfAbsent(m[2], mutableSetOf())
            schedule.getValue(m[2]) += m[0] to m[1]
        }
        val people = mutableSetOf(0, firstPerson)
        schedule.forEach { (_, ms) ->
            while (ms.isNotEmpty()) {
                ms.firstOrNull { (p1, p2) -> people.contains(p1) || people.contains(p2) }
                    ?.let { (p1, p2) ->
                        people += p1
                        people += p2
                        ms -= p1 to p2
                    }
                    ?: break
            }
        }
        return people.toList()
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val meetings = arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 3, 8), intArrayOf(1, 5, 10))

        val result = Solution().findAllPeople(6, meetings, 1)

        Assertions.assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 5)
    }

    @Test
    fun case2() {
        val meetings = arrayOf(intArrayOf(3, 1, 3), intArrayOf(1, 2, 2), intArrayOf(0, 3, 3))

        val result = Solution().findAllPeople(4, meetings, 3)

        Assertions.assertThat(result).containsExactlyInAnyOrder(0, 1, 3)
    }

    @Test
    fun case3() {
        val meetings = arrayOf(intArrayOf(3, 4, 2), intArrayOf(1, 2, 1), intArrayOf(2, 3, 1))

        val result = Solution().findAllPeople(5, meetings, 1)

        Assertions.assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3, 4)
    }

    @Test
    fun case4() {
        val meetings = arrayOf(intArrayOf(0, 2, 1), intArrayOf(1, 3, 1), intArrayOf(4, 5, 1))

        val result = Solution().findAllPeople(6, meetings, 1)

        Assertions.assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3)
    }
}
