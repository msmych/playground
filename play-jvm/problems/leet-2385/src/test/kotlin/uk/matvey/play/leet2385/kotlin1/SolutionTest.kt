package uk.matvey.play.leet2385.kotlin1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import uk.matvey.play.types.TreeNode

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
