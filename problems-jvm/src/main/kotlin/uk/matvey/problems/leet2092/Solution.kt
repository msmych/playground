package uk.matvey.problems.leet2092

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