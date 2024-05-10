package uk.matvey.problems.leet0786

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<DoubleArray> { (a), (b) -> b.compareTo(a) }
        arr.forEachIndexed { i, n ->
            heap.offer(doubleArrayOf(
                -1.0 * n / arr.last(),
                i.toDouble(),
                (arr.size - 1).toDouble()
            ))
        }
        repeat(k - 1) {
            val current = heap.poll()
            val ni = current[1].toInt()
            val di = current[2].toInt() - 1
            if (di > ni) {
                heap.offer(doubleArrayOf(
                    -1.0 * arr[ni] / arr[di],
                    ni.toDouble(),
                    di.toDouble()
                ))
            }
        }
        val result = heap.poll()
        return intArrayOf(arr[result[1].toInt()], arr[result[2].toInt()])
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val arr = intArrayOf(1, 2, 3, 5)

        val result = Solution().kthSmallestPrimeFraction(arr, 3)

        assertThat(result).isEqualTo(intArrayOf(2, 5))
    }

    @Test
    fun case2() {
        val arr = intArrayOf(1, 7)

        val result = Solution().kthSmallestPrimeFraction(arr, 1)

        assertThat(result).isEqualTo(intArrayOf(1, 7))
    }
}
