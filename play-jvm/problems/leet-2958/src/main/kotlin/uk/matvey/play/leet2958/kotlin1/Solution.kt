package uk.matvey.play.leet2958.kotlin1

class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val freq = mutableMapOf<Int, Int>()
        val problematic = mutableSetOf<Int>()
        var left = 0
        var right = 0
        var maxLen = 0
        while (right < nums.size) {
            val rightNum = nums[right]
            freq.merge(rightNum, 1, Integer::sum)
            if (freq.getValue(rightNum) > k) {
                problematic += rightNum
            }
            if (problematic.isEmpty()) {
                maxLen = maxOf(maxLen, right - left + 1)
            } else {
                val leftNum = nums[left]
                freq.merge(leftNum, -1, Integer::sum)
                if (freq.getValue(leftNum) <= k) {
                    problematic -= leftNum
                }
                left++
            }
            right++
        }
        return maxLen
    }
}