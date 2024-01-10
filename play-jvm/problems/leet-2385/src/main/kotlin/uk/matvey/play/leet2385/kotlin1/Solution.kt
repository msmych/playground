package uk.matvey.play.leet2385.kotlin1

import uk.matvey.play.types.TreeNode
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
