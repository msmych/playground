package uk.matvey.problems.leet2385

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TreeNode
import java.util.LinkedList
import java.util.Stack

class Solution {

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            stack.pop()?.let { node ->
                node.left?.let { left ->
                    graph.putIfAbsent(left.`val`, mutableSetOf())
                    graph.putIfAbsent(node.`val`, mutableSetOf())
                    graph[left.`val`]?.add(node.`val`)
                    graph[node.`val`]?.add(left.`val`)
                    stack.push(left)
                }
                node.right?.let { right ->
                    graph.putIfAbsent(right.`val`, mutableSetOf())
                    graph.putIfAbsent(node.`val`, mutableSetOf())
                    graph[right.`val`]?.add(node.`val`)
                    graph[node.`val`]?.add(right.`val`)
                    stack.push(right)
                }
            }
        }
        val visited = mutableSetOf<Int>()
        val queue = LinkedList<Int>()
        visited += start
        queue.offer(start)
        var steps = 0
        while (queue.isNotEmpty()) {
            var i = queue.size
            while (i > 0) {
                val v = queue.poll()
                graph[v]?.filterNot { visited.contains(it) }?.forEach {
                    visited += it
                    queue.offer(it)
                }
                i--
            }
            steps++
        }
        return steps - 1
    }
}

class SolutionTest {

    @Test
    fun case1() {
        val root = TreeNode.treeNode(1, 5, 3, null, 4, 10, 6, 9, 2)

        val result = Solution().amountOfTime(root, 3)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun case2() {
        val root = TreeNode.treeNode(1)

        val result = Solution().amountOfTime(root, 1)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun case3() {
        val root = TreeNode.treeNode(1, 2, null, 3, null, 4, null, 5)

        val result = Solution().amountOfTime(root, 2)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun case4() {
        val root = TreeNode.treeNode(1, null, 2, 3, 4, null, 5)

        val result = Solution().amountOfTime(root, 4)

        assertThat(result).isEqualTo(3)
    }
}
