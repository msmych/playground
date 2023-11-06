package uk.matvey.play.leet0424.kotlin1

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var maxLen = 0
        s.toSet().forEach { c ->
            var countOther = 0
            var left = 0
            var right = 0
            while (right < s.length) {
                if (countOther <= k) {
                    if (s[right] != c) {
                        countOther++
                    }
                    right++
                } else {
                    if (s[left] != c) {
                        countOther--
                    }
                    left++
                }
                if (countOther <= k && right - left > maxLen) {
                    maxLen = right - left
                }
            }
        }
        return maxLen
    }
}
