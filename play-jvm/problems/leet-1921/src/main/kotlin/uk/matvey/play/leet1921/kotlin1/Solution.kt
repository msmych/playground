package uk.matvey.play.leet1921.kotlin1

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val mins = dist.mapIndexed { i, d -> d / speed[i] + if (d % speed[i] > 0) 1 else 0 }.sorted()
        var count = 0
        var i = 0
        while (i < mins.size && count < mins[i]) {
            count++
            i++
        }
        return count
    }
}
