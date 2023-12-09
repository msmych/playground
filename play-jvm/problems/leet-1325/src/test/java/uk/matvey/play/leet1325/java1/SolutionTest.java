package uk.matvey.play.leet1325.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3, 2, null, 2, 4);

        TreeNode result = new Solution().removeLeafNodes(root, 2);

        assertThat(result).isEqualTo(TreeNode.treeNode(1, null, 3, null, 4));
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 3, 3, 3, 2);

        TreeNode result = new Solution().removeLeafNodes(root, 3);

        assertThat(result).isEqualTo(TreeNode.treeNode(1, 3, null, null, 2));
    }

    @Test
    public void case3() {
        var root = TreeNode.treeNode(1, 2, null, 2, null, 2);

        TreeNode result = new Solution().removeLeafNodes(root, 2);

        assertThat(result).isEqualTo(TreeNode.treeNode(1));
    }

    @Test
    public void case4() {
        var root = TreeNode.treeNode(1, 1, 1);

        TreeNode result = new Solution().removeLeafNodes(root, 1);

        assertThat(result).isEqualTo(TreeNode.treeNode());
    }

    @Test
    public void case5() {
        var root = TreeNode.treeNode(1, 2, 3);

        TreeNode result = new Solution().removeLeafNodes(root, 1);

        assertThat(result).isEqualTo(TreeNode.treeNode(1, 2, 3));
    }
}
