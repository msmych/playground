package uk.matvey.leet.problem2865.kotlin1

class Solution {
    fun maximumSumOfHeights(maxHeights: List<Int>): Long {
        return maxHeights.mapIndexed { tipIndex, tipHeight ->
            var ceiling = tipHeight
            var sum = 0L
            (0 until tipIndex).reversed().forEach { i ->
                val height = maxHeights[i]
                if (height < ceiling) {
                    ceiling = height
                }
                sum += ceiling
            }
            ceiling = tipHeight
            (tipIndex + 1 until maxHeights.size).forEach { i ->
                val height = maxHeights[i]
                if (height < ceiling) {
                    ceiling = height
                }
                sum += ceiling
            }
            sum + tipHeight
        }.max()
    }
}
