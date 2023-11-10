package uk.matvey.play.leet1743.kotlin1

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
