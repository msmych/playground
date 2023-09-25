package uk.matvey.leet.problem2865.kotlin1

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        val leftToRight = Array(maxHeights.size) { 0 }
        val rightToLeft = Array(maxHeights.size) { 0 }
        maxHeights.indices.forEach { i ->
            val prev = if (i == 0) 0 else leftToRight[i - 1]
            val left = if (i == 0) maxHeights[i] else maxHeights[i - 1]
            leftToRight[i] = prev + max(maxHeights[i] - left, 0)
        }
        maxHeights.indices.reversed().forEach { i ->
            val prev = if (i == maxHeights.size - 1) 0 else rightToLeft[i + 1]
            val right = if (i == maxHeights.size - 1) maxHeights[i] else maxHeights[i + 1]
            rightToLeft[i] = prev + max(maxHeights[i] - right, 0)
        }
        var max = 0
        var maxIdx = 0
        maxHeights.indices.forEach { i ->
            val localMax = leftToRight[i] + rightToLeft[i]
            if (localMax > max) {
                max = localMax
                maxIdx = i
            }
        }
        var sum = maxHeights[maxIdx].toLong()
        var ceiling = maxHeights[maxIdx]
        (0 until maxIdx).reversed().forEach { i ->
            val height = min(maxHeights[i], ceiling)
            if (height < ceiling) {
                ceiling = height
            }
            sum += height
        }
        ceiling = maxHeights[maxIdx]
        (maxIdx + 1 until maxHeights.size).forEach { i ->
            val height = min(maxHeights[i], ceiling)
            if (height < ceiling) {
                ceiling = height
            }
            sum += height
        }
        return sum
    }
}
