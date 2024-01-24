package uk.matvey.play.leet0042.kotlin1

import java.util.*
import kotlin.math.abs

class Solution {
    fun trap(height: IntArray): Int {
        val stack = Stack<Int>()
        var trap = 0
        var base = 0
        height.forEachIndexed { i, h ->
            var last = base
            while (stack.isNotEmpty() && height[stack.peek()] > last) {
                val j = stack.pop()
                trap += (i - j) * abs(last - height[j])
                last = height[j]
            }
            base = h
        }
        return trap
    }
}