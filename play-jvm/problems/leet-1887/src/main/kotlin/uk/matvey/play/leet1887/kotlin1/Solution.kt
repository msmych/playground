package uk.matvey.play.leet1887.kotlin1

class Solution {

    fun reductionOperations(nums: IntArray): Int {
        val sorted = nums.sorted()
        var count = 0
        var max = sorted.last()
        (0 until sorted.size - 1).reversed().forEach { i ->
            val num = sorted[i]
            if (num != max) {
                count += sorted.size - i - 1
                max = num
            }
        }
        return count
    }
}
