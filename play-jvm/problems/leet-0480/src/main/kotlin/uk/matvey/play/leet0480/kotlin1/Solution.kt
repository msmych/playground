package uk.matvey.play.leet0480.kotlin1

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
        val small = PriorityQueue<Int>(k / 2, Comparator.reverseOrder())
        val big = PriorityQueue<Int>(if (k % 2 == 0) k / 2 else k / 2 + 1)
        (0 until k).map { nums[it] }.sorted().forEachIndexed { i, n ->
            if (i < k / 2) {
                small.offer(n)
            } else {
                big.offer(n)
            }
        }
        return small to big
    }

    private fun median(
        k: Int,
        small: PriorityQueue<Int>,
        big: PriorityQueue<Int>
    ) = if (k % 2 == 0) (small.peek().toLong() + big.peek()) / 2.0 else big.peek().toDouble()
}
