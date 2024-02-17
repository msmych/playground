package uk.matvey.play.leet1642.kotlin1

import java.util.PriorityQueue

class Solution {
    
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        var bsum = 0
        val lheap = PriorityQueue<Int>()
        (1 until heights.size).forEach { i ->
            val diff = heights[i] - heights[i - 1]
            if (diff > 0) {
                if (lheap.size < ladders) {
                    lheap.offer(diff)
                } else {
                    val last = lheap.peek()
                    if (last != null && diff > last) {
                        bsum += lheap.poll()
                        lheap.offer(diff)
                    } else {
                        bsum += diff
                    }
                    if (bsum > bricks) {
                        return i - 1
                    }
                }
            }
        }
        return heights.size - 1
    }
}
