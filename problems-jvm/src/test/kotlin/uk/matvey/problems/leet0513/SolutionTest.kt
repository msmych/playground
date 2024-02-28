package uk.matvey.problems.leet0513

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.problems.leet.TreeNode

class SolutionTest {

    @Test
    fun case1() {
        val root = TreeNode.treeNode(2, 1, 3)

        val result = Solution().findBottomLeftValue(root)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun case2() {
        val root = TreeNode.treeNode(1, 2, 3, 4, null, 5, 6, null, null, 7)

        val result = Solution().findBottomLeftValue(root)

        assertThat(result).isEqualTo(7)
    }
}
