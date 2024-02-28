package uk.matvey.problems.leet0513

import uk.matvey.problems.leet.TreeNode

class Solution {

    fun findBottomLeftValue(root: TreeNode?): Int {
        val queue = ArrayDeque<TreeNode>()
        queue += root!!
        var left = root!!.`val`
        while (queue.isNotEmpty()) {
            left = queue.first().`val`
            repeat(queue.size) {
                val node = queue.removeFirst()
                node.left?.let(queue::add)
                node.right?.let(queue::add)
            }
        }
        return left
    }
}
