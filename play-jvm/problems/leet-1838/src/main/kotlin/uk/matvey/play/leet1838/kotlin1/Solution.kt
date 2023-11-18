package uk.matvey.play.leet1838.kotlin1

import java.util.TreeMap

class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        var max = 0
        var left = 0
        var right = 0
        var sum = 0
        while (right < nums.size) {
            var square = (right - left + 1) * sorted[right]
            sum += sorted[right]
            while (k < square - sum) {
                square -= sorted[right]
                sum -= sorted[left]
                left++
            }
            if (right - left + 1 > max) {
                max = right - left + 1
            }
            right++
        }
        return max
    }
}
