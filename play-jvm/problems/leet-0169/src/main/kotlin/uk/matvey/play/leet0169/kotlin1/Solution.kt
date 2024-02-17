package uk.matvey.play.leet0169.kotlin1

class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums
            .groupBy { it }
            .filterValues { it.size > nums.size / 2 }
            .map { (k, _) -> k }
            .first()
    }
}
