package uk.matvey.play.leet0872.kotlin1

import uk.matvey.play.types.TreeNode
import java.util.Stack

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return leafValueSeq(root1) == leafValueSeq(root2)
    }

    private fun leafValueSeq(root: TreeNode?): Collection<Int> {
        val seq = mutableListOf<Int>()
        val stack = Stack<TreeNode?>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            stack.pop()?.let { node ->
                if (node.left == null && node.right == null) {
                    seq += node.`val`
                } else {
                    node.right?.let(stack::push)
                    node.left?.let(stack::push)
                }
            }
        }
        return seq
    }
}
