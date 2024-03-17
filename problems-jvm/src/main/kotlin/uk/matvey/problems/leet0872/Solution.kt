package uk.matvey.problems.leet0872

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TreeNode
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

class SolutionTest {

    @Test
    fun case1() {
        val root1 = TreeNode.treeNode(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
        val root2 = TreeNode.treeNode(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)

        val result = Solution().leafSimilar(root1, root2)

        assertThat(result).isTrue()
    }

    @Test
    fun case2() {
        val root1 = TreeNode.treeNode(1, 2, 3)
        val root2 = TreeNode.treeNode(1, 3, 2)

        val result = Solution().leafSimilar(root1, root2)

        assertThat(result).isFalse()
    }

    @Test
    fun case3() {
        val root1 = TreeNode.treeNode(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 11, null, null, 8, 10)
        val root2 = TreeNode.treeNode(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)

        val result = Solution().leafSimilar(root1, root2)

        assertThat(result).isFalse()
    }
}
