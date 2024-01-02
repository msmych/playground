package uk.matvey.play.leet2610.kotlin1

class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val groups = nums.groupBy { it }.values.sortedBy { -it.size }
        return (0 until groups[0].size).map { i -> groups.filter { i < it.size }.map { it[i] } }
    }
}
