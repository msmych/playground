package uk.matvey.problems.leet0480

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class Solution {

    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        if (k == 1) {
            return nums.map { it.toDouble() }.toDoubleArray()
        }
        val slidingMedian = DoubleArray(nums.size - k + 1)
        val (leftHalf, rightHalf) = initHeaps(k, nums)
        slidingMedian[0] = median(k, leftHalf, rightHalf)
        (0 until nums.size - k).forEach { i ->
            val left = nums[i]
            if (left < rightHalf.peek()) {
                leftHalf.remove(left)
            } else {
                rightHalf.remove(left)
            }
            val right = nums[i + k]
            if (rightHalf.isNotEmpty() && right < rightHalf.peek() || rightHalf.isEmpty() && right < leftHalf.peek()) {
                leftHalf.offer(right)
            } else {
                rightHalf.offer(right)
            }
            if (leftHalf.size < rightHalf.size - 1) {
                leftHalf.offer(rightHalf.poll())
            } else if (rightHalf.size < leftHalf.size) {
                rightHalf.offer(leftHalf.poll())
            }
            slidingMedian[i + 1] = median(k, leftHalf, rightHalf)
        }
        return slidingMedian
    }

    private fun initHeaps(
        k: Int,
        nums: IntArray,
    ): Pair<PriorityQueue<Int>, PriorityQueue<Int>> {
        val leftHalf = PriorityQueue<Int>(k / 2, Comparator.reverseOrder())
        val rightHalf = PriorityQueue<Int>(if (k % 2 == 0) k / 2 else k / 2 + 1)
        (0 until k).map { nums[it] }.sorted().forEachIndexed { i, n ->
            if (i < k / 2) {
                leftHalf.offer(n)
            } else {
                rightHalf.offer(n)
            }
        }
        return leftHalf to rightHalf
    }

    private fun median(
        k: Int,
        leftHalf: PriorityQueue<Int>,
        rightHalf: PriorityQueue<Int>
    ) = if (k % 2 == 0) (leftHalf.peek().toLong() + rightHalf.peek()) / 2.0 else rightHalf.peek().toDouble()
}

class SolutionTest {

    @Test
    fun case1() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)

        val result = Solution().medianSlidingWindow(nums, 3)

        assertThat(result).containsExactly(1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000)
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 2, 3, 4, 2, 3, 1, 4, 2)

        val result = Solution().medianSlidingWindow(nums, 3)

        assertThat(result).containsExactly(2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000)
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)

        val result = Solution().medianSlidingWindow(nums, 4)

        assertThat(result).containsExactly(0.0, 1.0, 1.0, 4.0, 5.5)
    }

    @Test
    fun case4() {
        val nums = intArrayOf(1)

        val result = Solution().medianSlidingWindow(nums, 1)

        assertThat(result).containsExactly(1.0)
    }

    @Test
    fun case5() {
        val nums = intArrayOf(2147483647, 2147483647)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(2147483647.0)
    }

    @Test
    fun case6() {
        val nums = intArrayOf(2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(1073741824.0, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1073741827.0)
    }

    @Test
    fun case7() {
        val nums = intArrayOf(9, 7, 0, 3, 9, 8, 6, 5, 7, 6)

        val result = Solution().medianSlidingWindow(nums, 2)

        assertThat(result).containsExactly(
            8.00000,
            3.50000,
            1.50000,
            6.00000,
            8.50000,
            7.00000,
            5.50000,
            6.00000,
            6.50000
        )
    }
}
