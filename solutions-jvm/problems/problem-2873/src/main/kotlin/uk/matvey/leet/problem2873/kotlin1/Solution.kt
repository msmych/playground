package uk.matvey.leet.problem2873.kotlin1

class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var max = 0L
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val triplet = (nums[i] - nums[j]).toLong() * nums[k]
                    if (triplet > max) {
                        max = triplet
                    }
                }
            }
        }
        return max
    }
}
