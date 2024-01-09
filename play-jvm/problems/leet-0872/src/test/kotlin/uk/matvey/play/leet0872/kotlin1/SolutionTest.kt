package uk.matvey.play.leet0872.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.play.types.TreeNode

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
