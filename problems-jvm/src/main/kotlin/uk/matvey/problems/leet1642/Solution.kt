package uk.matvey.problems.leet1642

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

class SolutionTest {

    @Test
    fun case1() {
        val heights = intArrayOf(4, 2, 7, 6, 9, 14, 12)

        val result = Solution().furthestBuilding(heights, 5, 1)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun case2() {
        val heights = intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19)

        val result = Solution().furthestBuilding(heights, 10, 2)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun case3() {
        val heights = intArrayOf(14, 3, 19, 3)

        val result = Solution().furthestBuilding(heights, 17, 0)

        assertThat(result).isEqualTo(3)
    }
}
