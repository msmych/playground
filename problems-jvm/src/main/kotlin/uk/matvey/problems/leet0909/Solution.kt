package uk.matvey.problems.leet0909

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.ArrayDeque

class Solution {

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val steps = ArrayDeque<Int>()
        steps += 1
        val size = board.size
        val flatBoard = Array(size * size) {
            val absRow = it / size
            val row = size - absRow - 1
            val absCol = it % size
            val col = if (absRow % 2 == 0) absCol else size - absCol - 1
            board[row][col]
        }
        var i = 1
        val visited = HashSet<Int>()
        while (steps.isNotEmpty()) {
            var turns = steps.size
            while (turns > 0) {
                val start = steps.poll()
                for (j in 1..6) {
                    val next = start + j
                    val c = flatBoard[next - 1]
                    val target = if (c == -1) next else c
                    if (!visited.contains(target)) {
                        steps.offer(target)
                        visited += target
                        if (target == flatBoard.size) {
                            return i
                        }
                    }
                }
                turns--
            }
            i++
        }
        return -1
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 35, -1, -1, 13, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 15, -1, -1, -1, -1),
        )

        val result = Solution().snakesAndLadders(board)

        assertThat(result).isEqualTo(4)
    }
}
